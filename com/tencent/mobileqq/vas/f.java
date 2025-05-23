package com.tencent.mobileqq.vas;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.e;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.QColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.Typography;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$RichCardNameElem;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f implements Manager {
    public static final String C = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".CorlorNick/");
    public static AtomicBoolean D = new AtomicBoolean(false);
    private static c E = new c();

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f309061d;

    /* renamed from: f, reason: collision with root package name */
    public Handler f309063f;

    /* renamed from: h, reason: collision with root package name */
    ConcurrentHashMap<Integer, e> f309064h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private Vector<Integer> f309065i = new Vector<>();

    /* renamed from: m, reason: collision with root package name */
    private EmotionJsonDownloadListener f309066m = new b();

    /* renamed from: e, reason: collision with root package name */
    public C8907f f309062e = new C8907f();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements QueryCallback<EmoticonPackage> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f309067a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f309068b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ EditText f309069c;

        a(int i3, int i16, EditText editText) {
            this.f309067a = i3;
            this.f309068b = i16;
            this.f309069c = editText;
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void postQuery(EmoticonPackage emoticonPackage) {
            char[] l3 = com.tencent.mobileqq.emosm.e.l(this.f309067a, this.f309068b);
            char[] cArr = new char[7];
            cArr[0] = Typography.less;
            cArr[1] = '$';
            cArr[2] = l3[0];
            cArr[3] = l3[1];
            cArr[4] = l3[2];
            cArr[5] = l3[3];
            cArr[6] = Typography.greater;
            if (emoticonPackage != null && emoticonPackage.isAPNG == 2) {
                cArr[1] = '\u01ff';
            }
            for (int i3 = 0; i3 < 7; i3++) {
                if (cArr[i3] == 0) {
                    cArr[i3] = '\u0100';
                }
            }
            this.f309069c.getEditableText().replace(this.f309069c.getSelectionStart(), this.f309069c.getSelectionEnd(), String.valueOf(cArr));
            this.f309069c.requestFocus();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends EmotionJsonDownloadListener {
        b() {
        }

        @Override // com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener
        public void onJsonComplete(EmoticonPackage emoticonPackage, int i3, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNick", 2, "emotion onJsonComplete id = " + emoticonPackage.epId + " resultCode = " + i3);
            }
            Handler handler = f.this.f309063f;
            if (handler != null) {
                handler.sendEmptyMessage(257);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c implements Comparator<d> {
        c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            int i3 = dVar.f309071a;
            int i16 = dVar2.f309071a;
            if (i3 == i16) {
                int i17 = dVar.f309072b;
                int i18 = dVar2.f309072b;
                if (i17 == i18) {
                    return 0;
                }
                if (i17 > i18) {
                    return 1;
                }
                return -1;
            }
            if (i3 > i16) {
                return 1;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        int f309071a;

        /* renamed from: b, reason: collision with root package name */
        int f309072b;

        /* renamed from: c, reason: collision with root package name */
        SpannableString f309073c;

        d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class e {
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vas.f$f, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C8907f implements EmoticonListProvider {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<Integer> f309074a = new ArrayList<>();

        public C8907f() {
        }

        public void a(List<Integer> list) {
            if (list != null) {
                this.f309074a = new ArrayList<>(list);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
        public List<EmotionPanelInfo> getEmotionPanelInfo(boolean z16, boolean z17) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
            IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) f.this.f309061d.getRuntimeService(IEmoticonManagerService.class);
            Iterator<Integer> it = this.f309074a.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                EmoticonPackage syncFindEmoticonPackageById = iEmoticonManagerService.syncFindEmoticonPackageById(String.valueOf(intValue));
                if (syncFindEmoticonPackageById != null) {
                    arrayList.add(new EmotionPanelInfo(10, 7, syncFindEmoticonPackageById));
                } else {
                    EmoticonPackage emoticonPackage = new EmoticonPackage();
                    emoticonPackage.epId = String.valueOf(intValue);
                    emoticonPackage.wordingId = -1L;
                    emoticonPackage.jobType = 4;
                    emoticonPackage.isMagicFaceDownloading = false;
                    emoticonPackage.valid = true;
                    emoticonPackage.status = 0;
                    emoticonPackage.aio = true;
                    iEmoticonManagerService.saveEmoticonPackage(emoticonPackage);
                    IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) f.this.f309061d.getRuntimeService(IEmojiManagerService.class);
                    iEmojiManagerService.getEmojiListenerManager().addEmotionJsonDownloadListener(f.this.f309066m);
                    iEmojiManagerService.startDownloadEmosmJson(String.valueOf(intValue), EmojiManagerServiceConstant.JSON_EMOSM_MALL, null, true, 0);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f309076a;

        /* renamed from: b, reason: collision with root package name */
        public final int f309077b;

        public g(@Nullable String str, int i3) {
            this.f309076a = str;
            this.f309077b = i3;
        }
    }

    public f(QQAppInterface qQAppInterface) {
        this.f309061d = qQAppInterface;
    }

    public static void c(ISmallEmoticonInfo iSmallEmoticonInfo, QQAppInterface qQAppInterface, EditText editText) {
        if (iSmallEmoticonInfo.getEmoticon() == null) {
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "1", "", "", "", "", "", "", "");
            QLog.e("ColorNick", 1, "fail to send small_emotion.");
            return;
        }
        try {
            int parseInt = Integer.parseInt(iSmallEmoticonInfo.getEmoticon().eId);
            int parseInt2 = Integer.parseInt(iSmallEmoticonInfo.getEmoticon().epId);
            ((IEmoticonManagerService) qQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(String.valueOf(parseInt2), new a(parseInt2, parseInt, editText));
        } catch (NumberFormatException unused) {
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "4", "", "", "", "", "", "", "");
            QLog.e("ColorNick", 1, "fail to send small_emotion. id is not Int.");
        }
    }

    public static List<ColorClearableEditText.a> d(int i3, String str, Paint paint, ColorClearableEditText.b bVar, int i16) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ColorClearableEditText.k(arrayList, bVar, new com.tencent.mobileqq.text.c(str, i16).j());
        int ceil = (int) Math.ceil(paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX));
        Iterator it = arrayList.iterator();
        int i17 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ColorClearableEditText.a aVar = (ColorClearableEditText.a) it.next();
            int i18 = aVar.f315542e;
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 == 3) {
                        arrayList2.add(aVar);
                    }
                } else {
                    int width = ((EmoticonSpan) aVar.f315541d).getDrawable().getBounds().width();
                    if (width > (i3 - i17) - ceil) {
                        arrayList2.add(new ColorClearableEditText.a(1, aVar.f315538a, aVar.f315539b, MiniBoxNoticeInfo.APPNAME_SUFFIX, null));
                        return arrayList2;
                    }
                    arrayList2.add(aVar);
                    i17 += width;
                }
            } else {
                String m3 = SceneBuilder.m(i3 - i17, aVar.f315540c, paint);
                if (m3.equals(aVar.f315540c)) {
                    i17 += (int) Math.ceil(paint.measureText(aVar.f315540c));
                    arrayList2.add(aVar);
                } else {
                    aVar.f315540c = m3;
                    arrayList2.add(aVar);
                    break;
                }
            }
        }
        return arrayList2;
    }

    @NotNull
    public static g f(byte[] bArr) {
        int i3 = 0;
        String str = null;
        if (bArr == null) {
            return new g(null, 0);
        }
        try {
            Oidb_0x8fc$CommCardNameBuf oidb_0x8fc$CommCardNameBuf = new Oidb_0x8fc$CommCardNameBuf();
            oidb_0x8fc$CommCardNameBuf.mergeFrom(bArr);
            if (oidb_0x8fc$CommCardNameBuf.rpt_rich_card_name.has()) {
                StringBuilder sb5 = new StringBuilder();
                for (Oidb_0x8fc$RichCardNameElem oidb_0x8fc$RichCardNameElem : oidb_0x8fc$CommCardNameBuf.rpt_rich_card_name.get()) {
                    if (oidb_0x8fc$RichCardNameElem.bytes_ctrl.has()) {
                        sb5.append("<");
                        sb5.append(oidb_0x8fc$RichCardNameElem.bytes_ctrl.get().toStringUtf8());
                        sb5.append(">");
                    } else if (oidb_0x8fc$RichCardNameElem.bytes_text.has()) {
                        sb5.append(oidb_0x8fc$RichCardNameElem.bytes_text.get().toStringUtf8());
                    }
                }
                str = sb5.toString();
            }
            if (oidb_0x8fc$CommCardNameBuf.uint32_cool_id.has()) {
                i3 = oidb_0x8fc$CommCardNameBuf.uint32_cool_id.get();
            }
        } catch (InvalidProtocolBufferMicroException unused) {
        }
        return new g(str, i3);
    }

    public static String g(e.b bVar) {
        char[] cArr = new char[7];
        cArr[0] = Typography.less;
        cArr[1] = '%';
        int i3 = bVar.f309044d;
        cArr[2] = (char) ((i3 >>> 24) & 255);
        cArr[3] = (char) ((i3 >>> 16) & 255);
        cArr[4] = (char) ((i3 >>> 8) & 255);
        cArr[5] = (char) (i3 & 255);
        cArr[6] = Typography.greater;
        if (bVar.f309041a == 2) {
            if (i3 == 0) {
                return "";
            }
            cArr[1] = Typography.amp;
        }
        for (int i16 = 0; i16 < 7; i16++) {
            if (cArr[i16] == 0) {
                cArr[i16] = '\u0100';
            }
        }
        return new String(cArr);
    }

    public static f h(AppInterface appInterface) {
        return ((ao) appInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308432m;
    }

    @Nullable
    public static String i(byte[] bArr) {
        return f(bArr).f309076a;
    }

    @NotNull
    public static String j(ByteStringMicro byteStringMicro) {
        String i3 = i(byteStringMicro.toByteArray());
        if (i3 == null) {
            return byteStringMicro.toStringUtf8();
        }
        return i3;
    }

    public static int k(byte[] bArr) {
        return f(bArr).f309077b;
    }

    @org.jetbrains.annotations.Nullable
    private static CharSequence m(String str, int i3, Object obj, int i16, ArrayList<d> arrayList) {
        if (arrayList.size() > 0) {
            d[] dVarArr = (d[]) arrayList.toArray(new d[arrayList.size()]);
            Arrays.sort(dVarArr, E);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i17 = 0;
            for (d dVar : dVarArr) {
                if (dVar.f309071a >= i17) {
                    spannableStringBuilder.append((CharSequence) new QQText(str.subSequence(i17, dVar.f309072b), i16, i3, obj));
                } else {
                    spannableStringBuilder.append((CharSequence) dVar.f309073c);
                }
                i17 = dVar.f309072b;
            }
            if (i17 < str.length()) {
                spannableStringBuilder.append((CharSequence) new QQText(str.subSequence(i17, str.length()), i16, i3, obj));
            }
            return spannableStringBuilder;
        }
        return null;
    }

    public static int n(List<ColorClearableEditText.a> list, Paint paint, Rect rect) {
        Rect rect2 = new Rect();
        int i3 = 0;
        for (ColorClearableEditText.a aVar : list) {
            int i16 = aVar.f315542e;
            if (i16 != 1) {
                if (i16 == 2) {
                    i3 += ((EmoticonSpan) aVar.f315541d).getDrawable().getBounds().width();
                    rect.bottom = Math.max(rect.bottom, ((EmoticonSpan) aVar.f315541d).getDrawable().getBounds().height());
                }
            } else {
                i3 += (int) Math.ceil(paint.measureText(aVar.f315540c));
                String str = aVar.f315540c;
                paint.getTextBounds(str, 0, str.length(), rect2);
                rect.bottom = Math.max(rect.bottom, rect2.height());
            }
        }
        rect.left = 0;
        rect.right = i3;
        rect.top = 0;
        return i3;
    }

    public static String o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (i3 < str.length()) {
            if (str.charAt(i3) == '<') {
                int indexOf = str.indexOf(62, i3);
                if (indexOf > 0) {
                    i3 = indexOf;
                }
            } else {
                sb5.append(str.charAt(i3));
            }
            i3++;
        }
        return sb5.toString();
    }

    public static void p(TextView textView, Spannable spannable, int i3) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            r((QQAppInterface) runtime, textView, spannable, i3, false);
        }
    }

    public static void q(QQAppInterface qQAppInterface, TextView textView, Spannable spannable) {
        p(textView, spannable, 0);
    }

    public static void r(QQAppInterface qQAppInterface, TextView textView, Spannable spannable, int i3, boolean z16) {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return;
        }
        i[] iVarArr = (i[]) spannable.getSpans(0, spannable.length(), i.class);
        if (iVarArr != null && iVarArr.length > 0) {
            i iVar = iVarArr[0];
            int i16 = iVar.f309559d;
            if (i16 == 2) {
                textView.setTextColor(iVar.f309560e);
                if (textView instanceof ColorClearableEditText) {
                    ((ColorClearableEditText) textView).setSpecialColor(0, null, null, 0, null);
                } else if (textView instanceof ColorNickTextView) {
                    ((ColorNickTextView) textView).setSpecialColor(0, null, null, 0, null);
                } else if (spannable instanceof QColorNickTextView) {
                    ((QColorNickTextView) textView).setSpecialColor(0, null, null, 0, null);
                }
            } else if (i16 == 3) {
                h(qQAppInterface).e(iVar.f309560e);
                t(textView, null);
            }
        } else if (textView instanceof ColorClearableEditText) {
            ((ColorClearableEditText) textView).setSpecialColor(0, null, null, 0, null);
        } else if (textView instanceof ColorNickTextView) {
            ((ColorNickTextView) textView).setSpecialColor(0, null, null, 0, null);
        }
        com.tencent.mobileqq.vas.troopnick.a.c(textView, textView.getContext(), i3, z16, true);
    }

    public static void s(QQAppInterface qQAppInterface, TextView textView, Spannable spannable, int i3, boolean z16, boolean z17) {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return;
        }
        i[] iVarArr = (i[]) spannable.getSpans(0, spannable.length(), i.class);
        if (iVarArr != null && iVarArr.length > 0) {
            i iVar = iVarArr[0];
            int i16 = iVar.f309559d;
            if (i16 == 2) {
                textView.setTextColor(iVar.f309560e);
                if (textView instanceof ColorClearableEditText) {
                    ((ColorClearableEditText) textView).setSpecialColor(0, null, null, 0, null);
                } else if (textView instanceof ColorNickTextView) {
                    ((ColorNickTextView) textView).setSpecialColor(0, null, null, 0, null);
                } else if (spannable instanceof QColorNickTextView) {
                    ((QColorNickTextView) textView).setSpecialColor(0, null, null, 0, null);
                }
            } else if (i16 == 3) {
                h(qQAppInterface).e(iVar.f309560e);
                t(textView, null);
            }
        } else if (textView instanceof ColorClearableEditText) {
            ((ColorClearableEditText) textView).setSpecialColor(0, null, null, 0, null);
        } else if (textView instanceof ColorNickTextView) {
            ((ColorNickTextView) textView).setSpecialColor(0, null, null, 0, null);
        }
        com.tencent.mobileqq.vas.troopnick.a.c(textView, textView.getContext(), i3, z16, z17);
    }

    private static void t(TextView textView, e eVar) {
        if (textView instanceof ColorNickTextView) {
            ((ColorNickTextView) textView).H = true;
        } else if (textView instanceof QColorNickTextView) {
            ((QColorNickTextView) textView).needRefreshSpecialColor = true;
        }
    }

    public static CharSequence u(String str, MessageRecord messageRecord, int i3, int i16) {
        CharSequence charSequence;
        MessageForReplyText.SourceMsgInfo sourceMsgInfo;
        if (messageRecord != null) {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(com.tencent.mobileqq.service.message.i.f286266i);
            if ((messageRecord instanceof MessageForReplyText) && (sourceMsgInfo = ((MessageForReplyText) messageRecord).mSourceMsgInfo) != null) {
                extInfoFromExtStr = com.tencent.mobileqq.troop.text.b.a(sourceMsgInfo.mSourceMsgSenderUin, extInfoFromExtStr);
            }
            charSequence = v(str, extInfoFromExtStr, i3, messageRecord, i16);
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            return new QQText(str, i16, i3, messageRecord);
        }
        return charSequence;
    }

    public static CharSequence v(String str, String str2, int i3, Object obj, int i16) {
        ArrayList<AtTroopMemberInfo> troopMemberInfoFromExtrJson;
        int i17;
        if (!TextUtils.isEmpty(str2) && (troopMemberInfoFromExtrJson = MessageForText.getTroopMemberInfoFromExtrJson(str2)) != null && troopMemberInfoFromExtrJson.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i18 = 0; i18 < troopMemberInfoFromExtrJson.size(); i18++) {
                AtTroopMemberInfo atTroopMemberInfo = troopMemberInfoFromExtrJson.get(i18);
                short s16 = atTroopMemberInfo.startPos;
                if (s16 >= 0 && s16 + atTroopMemberInfo.textLen <= str.length()) {
                    d dVar = new d();
                    short s17 = atTroopMemberInfo.startPos;
                    dVar.f309071a = s17;
                    if (s17 + atTroopMemberInfo.textLen > str.length()) {
                        i17 = str.length();
                    } else {
                        i17 = atTroopMemberInfo.textLen + atTroopMemberInfo.startPos;
                    }
                    dVar.f309072b = i17;
                    dVar.f309073c = new com.tencent.mobileqq.text.c(str.subSequence(dVar.f309071a, i17), i3).j();
                    arrayList.add(dVar);
                }
            }
            CharSequence m3 = m(str, i3, obj, i16, arrayList);
            if (m3 != null) {
                return m3;
            }
        }
        return new QQText(str, i16, i3, obj);
    }

    public static CharSequence w(MessageRecord messageRecord, MsgSummary msgSummary) {
        String charSequence;
        SpannableString spannableString;
        if (!TextUtils.isEmpty(msgSummary.strContent) || !TextUtils.isEmpty(msgSummary.suffix)) {
            if (!TextUtils.isEmpty(msgSummary.strContent)) {
                charSequence = msgSummary.strContent.toString();
                if (!TextUtils.isEmpty(msgSummary.strPrefix) && TextUtils.indexOf(msgSummary.strContent, msgSummary.strPrefix) == 0) {
                    charSequence = msgSummary.strContent.length() > msgSummary.strPrefix.length() + 2 ? (String) charSequence.subSequence(msgSummary.strPrefix.length() + 2, msgSummary.strContent.length()) : "";
                }
            } else {
                charSequence = msgSummary.suffix.toString();
            }
            if (!TextUtils.isEmpty(msgSummary.strPrefix)) {
                spannableString = new com.tencent.mobileqq.text.c(msgSummary.strPrefix, 16).j();
            } else {
                spannableString = null;
            }
            CharSequence u16 = u(charSequence, messageRecord, 16, 5);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (spannableString != null) {
                spannableStringBuilder.append((CharSequence) spannableString).append((CharSequence) MsgSummary.STR_COLON);
            }
            spannableStringBuilder.append(u16);
            msgSummary.strContent = new QQText(spannableStringBuilder, 5, 16);
        }
        return msgSummary.strContent;
    }

    public e e(int i3) {
        return null;
    }

    public Shader l(int i3, List<ColorClearableEditText.a> list, float f16, float f17, Rect rect, Paint paint, int i16, int i17) {
        e(i3);
        return null;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
