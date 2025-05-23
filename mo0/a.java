package mo0;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.aio.input.at.utils.data.AtUserWithRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ze1.b;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements ye1.a {

    /* renamed from: h, reason: collision with root package name */
    public static final int f417087h = a.class.hashCode() << 4;

    /* renamed from: a, reason: collision with root package name */
    private final b f417088a;

    /* renamed from: d, reason: collision with root package name */
    private String f417091d;

    /* renamed from: e, reason: collision with root package name */
    private Context f417092e;

    /* renamed from: f, reason: collision with root package name */
    private EditText f417093f;

    /* renamed from: c, reason: collision with root package name */
    private boolean f417090c = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f417094g = false;

    /* renamed from: b, reason: collision with root package name */
    private LinkedHashMap<String, yo0.a> f417089b = new LinkedHashMap<>();

    public a(b bVar, Context context, EditText editText) {
        this.f417088a = bVar;
        this.f417092e = context;
        this.f417093f = editText;
    }

    private void h(String str) {
        yo0.a aVar = this.f417089b.get(str);
        Editable editableText = this.f417093f.getEditableText();
        if (aVar != null) {
            if (QLog.isColorLevel()) {
                QLog.i("GuildAtPanelClickProcess", 2, "deleteAtSpan: invoked.  editableText: " + ((Object) editableText) + " need delete atTag: " + aVar);
            }
            int i3 = aVar.f450716a;
            editableText.delete(i3, aVar.f450717b.length() + i3);
            if (QLog.isColorLevel()) {
                QLog.d("GuildAtPanelClickProcess", 2, "deleteAtSpan: invoked. ", " after delete, editableText: ", editableText);
            }
        }
    }

    private void i() {
        InputMethodManager inputMethodManager;
        Context context = this.f417092e;
        if ((context instanceof Activity) && (inputMethodManager = (InputMethodManager) ((Activity) context).getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f417093f.getWindowToken(), 0);
        }
    }

    private void j(IGProUserInfo iGProUserInfo, String str, int i3, AtRoleInfo atRoleInfo) {
        if (this.f417089b.containsKey(str)) {
            QLog.i("GuildAtPanelClickProcess", 1, "insertAtSpan: invoked. already exists member: " + iGProUserInfo);
            return;
        }
        String name = iGProUserInfo.getName();
        SpannableString q16 = com.tencent.guild.aio.input.at.utils.b.q(this.f417092e, iGProUserInfo.getTinyId(), name, name, this.f417093f, 0, false, true, i3, atRoleInfo);
        QLog.i("GuildAtPanelClickProcess", 1, "insertAtSpan: curFriendUin: " + iGProUserInfo.getTinyId() + " inputDisplayName:" + name + " atSpanString:" + ((Object) q16));
        if (TextUtils.isEmpty(q16)) {
            return;
        }
        Editable editableText = this.f417093f.getEditableText();
        yo0.a aVar = new yo0.a(k(editableText, this.f417093f.getSelectionStart(), q16, this.f417091d), q16);
        this.f417091d = null;
        this.f417089b.put(str, aVar);
        QLog.i("GuildAtPanelClickProcess", 1, "insertAtSpan: invoked.  atTag: " + aVar + " editableText: " + ((Object) editableText));
    }

    public static int k(Editable editable, int i3, SpannableString spannableString, String str) {
        boolean z16 = false;
        int p16 = p(editable, 64, 65312, Math.max(0, i3 - spannableString.length()), i3);
        if (p16 < 0) {
            editable.insert(i3, spannableString);
            return i3;
        }
        String spannableString2 = spannableString.toString();
        int i16 = (i3 - p16) - 1;
        if (i16 >= 0 && i16 <= spannableString2.length()) {
            CharSequence subSequence = editable.subSequence(p16 + 1, i3);
            if (TextUtils.equals(str, subSequence) || spannableString2.contains(subSequence)) {
                z16 = true;
            }
        }
        if (z16) {
            editable.replace(p16, i3, spannableString);
            return p16;
        }
        editable.insert(i3, spannableString);
        return i3;
    }

    public static <T> boolean m(Spanned spanned, int i3, Class<T> cls) {
        Object[] spans;
        if (i3 >= 0 && i3 < spanned.length() && (spans = spanned.getSpans(i3, i3, cls)) != null && spans.length > 0) {
            for (Object obj : spans) {
                int spanStart = spanned.getSpanStart(obj);
                int spanEnd = spanned.getSpanEnd(obj);
                if (i3 >= spanStart && i3 < spanEnd) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int p(Spanned spanned, int i3, int i16, int i17, int i18) {
        boolean z16;
        String substring = spanned.toString().substring(i17, i18);
        int length = substring.length();
        int i19 = i18 - i17;
        if (i19 > 0 && length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i26 = -1;
        int i27 = 0;
        int i28 = -1;
        while (z16 && i27 < length) {
            int i29 = i19 - 1;
            i28 = Math.max(substring.lastIndexOf(i3, i29), substring.lastIndexOf(i16, i29));
            if (m(spanned, i28 + i17, AtTroopMemberSpan.class)) {
                break;
            }
            i27++;
            z16 = false;
        }
        i26 = i28;
        if (i26 >= 0) {
            return i26 + i17;
        }
        return i26;
    }

    private void q() {
        InputMethodManager inputMethodManager;
        Context context = this.f417092e;
        if ((context instanceof Activity) && (inputMethodManager = (InputMethodManager) ((Activity) context).getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null) {
            inputMethodManager.showSoftInput(this.f417093f, 0);
        }
    }

    private void r(String str) {
        yo0.a aVar;
        LinkedHashMap<String, yo0.a> linkedHashMap = new LinkedHashMap<>();
        Iterator<Map.Entry<String, yo0.a>> it = this.f417089b.entrySet().iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                Map.Entry<String, yo0.a> next = it.next();
                if (next.getKey().equals(str)) {
                    aVar = next.getValue();
                    break;
                }
                i3++;
            } else {
                aVar = null;
                break;
            }
        }
        int i16 = 0;
        for (Map.Entry<String, yo0.a> entry : this.f417089b.entrySet()) {
            if (i16 < i3) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            } else if (i16 != i3) {
                if (aVar != null) {
                    yo0.a value = entry.getValue();
                    int length = value.f450716a - aVar.f450717b.length();
                    if (length < 0) {
                        length = 0;
                    }
                    linkedHashMap.put(entry.getKey(), new yo0.a(length, value.f450717b));
                } else {
                    QLog.d("GuildAtPanelClickProcess", 2, "deletedTag == null deletedPos = " + i3 + " currentPos = " + i16);
                }
            }
            i16++;
        }
        this.f417089b = linkedHashMap;
    }

    @Override // ye1.a
    public void a(Set<IGProUserInfo> set) {
        LinkedHashMap<String, yo0.a> linkedHashMap = this.f417089b;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    @Override // ye1.a
    public void b() {
        i();
    }

    @Override // ye1.a
    public void d(boolean z16, int i3, List<IGProUserInfo> list) {
        LinkedHashMap<String, yo0.a> linkedHashMap = this.f417089b;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        if (this.f417094g) {
            q();
            this.f417094g = false;
        }
    }

    @Override // ye1.a
    public void e(boolean z16, String str, IGProUserInfo iGProUserInfo, int i3, int i16) {
        AtRoleInfo atRoleInfo;
        int i17;
        String tinyId = iGProUserInfo.getTinyId();
        if (iGProUserInfo instanceof AtUserWithRoleInfo) {
            AtUserWithRoleInfo atUserWithRoleInfo = (AtUserWithRoleInfo) iGProUserInfo;
            i17 = atUserWithRoleInfo.getAtType();
            atRoleInfo = atUserWithRoleInfo.getAtRole();
            tinyId = atUserWithRoleInfo.getKey();
        } else {
            atRoleInfo = null;
            i17 = 2;
        }
        o(z16, iGProUserInfo, tinyId, i17, i16, atRoleInfo);
    }

    public boolean l() {
        return this.f417090c;
    }

    public void n(String str) {
        this.f417091d = str;
    }

    protected void o(boolean z16, IGProUserInfo iGProUserInfo, String str, int i3, int i16, AtRoleInfo atRoleInfo) {
        this.f417090c = true;
        if (z16) {
            j(iGProUserInfo, str, i3, atRoleInfo);
        } else {
            if (i16 != f417087h) {
                h(str);
            }
            r(str);
        }
        this.f417090c = false;
        b bVar = this.f417088a;
        if (bVar != null && !bVar.h()) {
            this.f417094g = true;
            this.f417088a.dismiss();
        }
    }

    @Override // ye1.b
    public void f() {
    }

    @Override // ye1.a
    public void g(boolean z16) {
    }
}
