package com.tencent.mobileqq.troop.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.widget.EditText;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.c;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.util.aw;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.f;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends DynamicDrawableSpan {
    static IPatchRedirector $redirector_;
    protected String C;
    protected String D;
    protected int E;
    protected Context F;
    protected Drawable G;
    protected ColorClearableEditText.b H;

    /* renamed from: d, reason: collision with root package name */
    private String f299221d;

    /* renamed from: e, reason: collision with root package name */
    protected String f299222e;

    /* renamed from: f, reason: collision with root package name */
    private String f299223f;

    /* renamed from: h, reason: collision with root package name */
    protected int f299224h;

    /* renamed from: i, reason: collision with root package name */
    protected int f299225i;

    /* renamed from: m, reason: collision with root package name */
    private String f299226m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.text.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class C8784a implements Comparator<a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Spannable f299227d;

        C8784a(Spannable spannable) {
            this.f299227d = spannable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) spannable);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2)).intValue();
            }
            int spanStart = this.f299227d.getSpanStart(aVar);
            int spanStart2 = this.f299227d.getSpanStart(aVar2);
            if (spanStart < spanStart2) {
                return -1;
            }
            if (spanStart > spanStart2) {
                return 1;
            }
            return 0;
        }
    }

    protected a(Context context, String str, String str2, int i3, Paint paint, boolean z16) {
        super(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, str2, Integer.valueOf(i3), paint, Boolean.valueOf(z16));
            return;
        }
        this.f299221d = "";
        this.f299222e = "";
        this.f299223f = "";
        this.f299224h = -1;
        this.f299225i = 0;
        this.C = "";
        this.D = "";
        this.E = -4331268;
        this.H = new ColorClearableEditText.b();
        this.f299221d = str;
        String format = String.format("%s%s", "@", new c(str2, 32).j());
        this.f299222e = z16 ? h(format) : format;
        this.f299225i = i3;
        this.F = context;
        a(paint);
    }

    public static String c(Spannable spannable, ArrayList<AtTroopMemberInfo> arrayList) {
        return d(spannable, arrayList).toString();
    }

    public static Spannable d(Spannable spannable, ArrayList<AtTroopMemberInfo> arrayList) {
        String str;
        boolean z16;
        boolean z17;
        if (arrayList != null && spannable != null) {
            arrayList.clear();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannable);
            int length = spannableStringBuilder.length();
            a[] aVarArr = (a[]) spannable.getSpans(0, length - 1, a.class);
            if (aVarArr.length == 0) {
                return spannableStringBuilder;
            }
            if (aVarArr.length > 1) {
                Arrays.sort(aVarArr, new C8784a(spannable));
            }
            int i3 = 0;
            for (a aVar : aVarArr) {
                int spanStart = spannable.getSpanStart(aVar) + i3;
                int spanEnd = spannable.getSpanEnd(aVar) + i3;
                if (!TextUtils.isEmpty(aVar.D)) {
                    str = aVar.D;
                } else {
                    str = aVar.f299222e;
                    if (!TextUtils.isEmpty(aVar.f299226m)) {
                        str = aVar.f299226m;
                    }
                }
                try {
                    spannableStringBuilder.replace(spanStart, spanEnd, (CharSequence) str);
                    AtTroopMemberInfo atTroopMemberInfo = new AtTroopMemberInfo();
                    if (!TextUtils.isEmpty(aVar.f299221d)) {
                        atTroopMemberInfo.uin = Long.valueOf(aVar.f299221d).longValue();
                        if (aVar.f299221d.equalsIgnoreCase("0")) {
                            atTroopMemberInfo.flag = (byte) 1;
                        }
                    } else if (!TextUtils.isEmpty(aVar.C)) {
                        atTroopMemberInfo.flag = (byte) 2;
                        atTroopMemberInfo.channelId = Long.valueOf(aVar.C).longValue();
                    }
                    atTroopMemberInfo.startPos = (short) spanStart;
                    atTroopMemberInfo.textLen = (short) str.length();
                    arrayList.add(atTroopMemberInfo);
                    i3 += atTroopMemberInfo.textLen - (spanEnd - spanStart);
                } catch (IndexOutOfBoundsException unused) {
                    if (QLog.isColorLevel()) {
                        String str2 = spannableStringBuilder.toString() + ",IndexOutOfBoundsException, convertToSendMsg, start:%d | end:%d | msgBLen:%d";
                        Integer valueOf = Integer.valueOf(spanStart);
                        z16 = false;
                        Integer valueOf2 = Integer.valueOf(spanEnd);
                        z17 = true;
                        QLog.e("AtTroopMemberSpan", 2, String.format(str2, valueOf, valueOf2, Integer.valueOf(length)));
                    }
                }
                z16 = false;
                z17 = true;
            }
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (android.text.TextUtils.isEmpty(r12) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0046, code lost:
    
        if (o(r11, r0, r12) != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a e(AppRuntime appRuntime, Context context, String str, String str2, String str3, boolean z16, int i3, Paint paint, boolean z17, boolean z18) {
        String h16;
        String str4;
        if (appRuntime == null || context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i3 <= 0) {
            return null;
        }
        if (z17) {
            if (!z16 && !str2.equalsIgnoreCase("0")) {
                h16 = "";
                if (TextUtils.isEmpty("")) {
                }
                str4 = h16;
            }
            str4 = str3;
        } else {
            if (!str2.equalsIgnoreCase("0")) {
                h16 = ac.h(appRuntime, str2, true);
                str4 = str3;
            }
            str4 = str3;
        }
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_AT_MEMBER_DISC, 2, " memUin:" + str2 + " troopMemName:" + aw.a(str4) + " isTroop:" + z17);
        }
        return new a(context, str2, str4, i3, paint, z18);
    }

    public static SpannableString f(AppRuntime appRuntime, Context context, String str, String str2, String str3, boolean z16, EditText editText, boolean z17, boolean z18) {
        return g(appRuntime, context, str, str2, str3, z16, editText, z17, z18, true);
    }

    public static SpannableString g(AppRuntime appRuntime, Context context, String str, String str2, String str3, boolean z16, EditText editText, boolean z17, boolean z18, boolean z19) {
        a aVar;
        if (appRuntime == null || context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || editText == null) {
            return null;
        }
        try {
            aVar = e(appRuntime, context, str, str2, str3, z16, (editText.getWidth() - editText.getPaddingLeft()) - editText.getPaddingRight(), editText.getPaint(), z17, z19);
        } catch (OutOfMemoryError unused) {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        String str4 = aVar.f299222e;
        if (!z19) {
            str4 = l(str4);
        }
        SpannableString spannableString = new SpannableString(new c(str4 + " ", 16).d());
        spannableString.setSpan(aVar, 0, str4.length(), 33);
        return spannableString;
    }

    private static String h(CharSequence charSequence) {
        int i3;
        StringBuffer stringBuffer = new StringBuffer(charSequence);
        int i16 = 0;
        while (i16 < stringBuffer.length()) {
            int codePointAt = stringBuffer.codePointAt(i16);
            if (codePointAt == 20 && i16 < stringBuffer.length() - 1) {
                stringBuffer.delete(i16, i16 + 2);
            } else if (EmotcationConstants.EMOJI_MAP.get(codePointAt, -1) >= 0) {
                if (codePointAt > 65535 && stringBuffer.length() >= (i3 = i16 + 2)) {
                    stringBuffer.delete(i16, i3);
                } else {
                    stringBuffer.delete(i16, i16 + 1);
                }
            } else if (j(stringBuffer, codePointAt, i16)) {
                stringBuffer.delete(i16, i16 + 4);
            } else {
                i16++;
            }
            i16--;
            i16++;
        }
        return stringBuffer.toString();
    }

    public static int i(StringBuffer stringBuffer, int i3) {
        int i16;
        int doubleEmoji;
        int i17;
        int i18 = i3 + 1;
        if (stringBuffer.length() < i18) {
            return 0;
        }
        int codePointAt = stringBuffer.codePointAt(i3);
        int singleEmoji = EmotcationConstants.getSingleEmoji(codePointAt);
        int i19 = 2;
        int i26 = -1;
        if (codePointAt > 65535) {
            int i27 = i3 + 2;
            if (stringBuffer.length() > i27) {
                i26 = stringBuffer.codePointAt(i27);
            }
            i16 = 2;
        } else {
            i16 = 1;
            if (stringBuffer.length() > i18) {
                i26 = stringBuffer.codePointAt(i18);
            }
        }
        if (codePointAt <= 65535 && i26 == 65039 && stringBuffer.length() > (i17 = i3 + 2)) {
            i26 = stringBuffer.codePointAt(i17);
        } else {
            i19 = i16;
        }
        if ((singleEmoji < 0 || EmotcationConstants.isSkinEmoji(i26)) && (doubleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt, i26)) >= 0) {
            if (i26 > 65535) {
                i19 += 2;
            } else {
                i19++;
            }
            singleEmoji = doubleEmoji;
        }
        if (singleEmoji <= 0) {
            return 0;
        }
        return i19;
    }

    private static boolean j(StringBuffer stringBuffer, int i3, int i16) {
        int i17;
        int codePointAt;
        if (i3 <= 65535 || stringBuffer.length() <= (i17 = i16 + 2) || (codePointAt = stringBuffer.codePointAt(i17)) <= 65535 || EmotcationConstants.getDoubleEmoji(i3, codePointAt) == -1) {
            return false;
        }
        return true;
    }

    public static StringBuilder k(QQAppInterface qQAppInterface, StringBuilder sb5, String str, String str2, boolean z16) {
        if (!TextUtils.isEmpty(sb5.toString()) && !TextUtils.isEmpty(str2) && !z16) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                int i3 = 0;
                for (int i16 = 0; i16 < length; i16++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i16);
                    byte optInt = (byte) jSONObject.optInt("flag", 1);
                    String optString = jSONObject.optString("uin");
                    int optInt2 = jSONObject.optInt("startPos", 0);
                    int optInt3 = jSONObject.optInt("textLen", 0);
                    if (optInt == 0) {
                        String str3 = "@" + ac.n(qQAppInterface, str2, optString);
                        sb5 = sb5.replace(optInt2 + i3, optInt2 + optInt3 + i3, str3);
                        i3 += str3.length() - optInt3;
                    }
                }
            } catch (JSONException e16) {
                QLog.e(LogTag.TAG_AT_MEMBER_DISC, 1, "replaceAtMsgByMarkName_1 ", e16);
            } catch (Exception e17) {
                QLog.e(LogTag.TAG_AT_MEMBER_DISC, 1, "replaceAtMsgByMarkName_2", e17);
            }
            return sb5;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AtTroopMemberSpan_At_Me_DISC", 2, "Recv replaceAtMsgByMarkName return discUin:" + str2);
        }
        return sb5;
    }

    public static String l(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i3 = 0;
        while (i3 < stringBuffer.length()) {
            if (stringBuffer.codePointAt(i3) == 20 && i3 < stringBuffer.length() - 1) {
                stringBuffer.replace(i3, i3 + 2, "##");
                i3++;
            } else {
                int i16 = i(stringBuffer, i3);
                if (i16 > 0) {
                    StringBuilder sb5 = new StringBuilder();
                    for (int i17 = 0; i17 < i16; i17++) {
                        sb5.append('#');
                    }
                    stringBuffer.replace(i3, i3 + i16, sb5.toString());
                    i3 += i16 - 1;
                }
            }
            i3++;
        }
        return stringBuffer.toString();
    }

    public static void m(int i3, String str, ChatMessage chatMessage) {
        if (i3 == 1) {
            chatMessage.saveExtInfoToExtStr("troop_at_info_list", str);
        } else if (i3 == 3000) {
            chatMessage.saveExtInfoToExtStr("disc_at_info_list", str);
        } else if (i3 == 10014) {
            chatMessage.saveExtInfoToExtStr(IGuildMessageUtilsApi.GUILD_AT_INFO_LIST, str);
        }
    }

    public static void n(int i3, ArrayList<AtTroopMemberInfo> arrayList, ChatMessage chatMessage) {
        if ((i3 == 3000 || i3 == 1 || i3 == 10014) && arrayList.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<AtTroopMemberInfo> it = arrayList.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    jSONArray.put(i16, it.next().toJsonObject());
                    i16++;
                }
                if (i3 == 1) {
                    chatMessage.saveExtInfoToExtStr("troop_at_info_list", jSONArray.toString());
                    return;
                } else if (i3 == 3000) {
                    chatMessage.saveExtInfoToExtStr("disc_at_info_list", jSONArray.toString());
                    return;
                } else {
                    if (i3 == 10014) {
                        chatMessage.saveExtInfoToExtStr(IGuildMessageUtilsApi.GUILD_AT_INFO_LIST, jSONArray.toString());
                        return;
                    }
                    return;
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        if ((i3 == 3000 || i3 == 1 || i3 == 10014) && arrayList.size() == 0) {
            if (i3 == 1) {
                chatMessage.removeExtInfoToExtStr("troop_at_info_list");
            } else if (i3 == 3000) {
                chatMessage.removeExtInfoToExtStr("disc_at_info_list");
            } else if (i3 == 10014) {
                chatMessage.removeExtInfoToExtStr(IGuildMessageUtilsApi.GUILD_AT_INFO_LIST);
            }
        }
    }

    private static boolean o(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !str2.equals(str)) {
            return false;
        }
        return !TextUtils.isEmpty(str3);
    }

    protected void a(Paint paint) {
        float f16;
        int i3;
        Canvas canvas;
        float measureText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) paint);
            return;
        }
        if (this.G != null) {
            return;
        }
        List<ColorClearableEditText.a> b16 = b(paint);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f17 = -fontMetrics.top;
        int ceil = (int) Math.ceil(fontMetrics.bottom - r3);
        int i16 = 2;
        RectF rectF = new RectF(0.0f, fontMetrics.ascent - fontMetrics.top, this.f299224h - 2, fontMetrics.descent + f17);
        Bitmap createBitmap = Bitmap.createBitmap(this.f299224h, ceil, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        int color = paint.getColor();
        paint.setColor(this.E);
        canvas2.drawRect(rectF, paint);
        paint.setColor(color);
        float f18 = 0.0f;
        for (ColorClearableEditText.a aVar : b16) {
            int i17 = aVar.f315542e;
            if (i17 != 1) {
                if (i17 != i16) {
                    i3 = ceil;
                    canvas = canvas2;
                    canvas2 = canvas;
                    ceil = i3;
                    i16 = 2;
                } else {
                    EmoticonSpan emoticonSpan = (EmoticonSpan) aVar.f315541d;
                    int height = emoticonSpan.getDrawable().getBounds().height();
                    int i18 = (ceil - height) / 2;
                    int i19 = (height + ceil) / 2;
                    f16 = f18;
                    i3 = ceil;
                    canvas = canvas2;
                    emoticonSpan.draw(canvas2, "", 0, 0, f18, i18, i19, i19, paint);
                    measureText = emoticonSpan.getDrawable().getBounds().width();
                }
            } else {
                f16 = f18;
                i3 = ceil;
                canvas = canvas2;
                canvas.drawText(aVar.f315540c, f16, f17, paint);
                measureText = paint.measureText(aVar.f315540c);
            }
            f18 = f16 + measureText;
            canvas2 = canvas;
            ceil = i3;
            i16 = 2;
        }
        int i26 = ceil;
        Canvas canvas3 = canvas2;
        canvas3.save();
        canvas3.restore();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.F.getResources(), createBitmap);
        this.G = bitmapDrawable;
        bitmapDrawable.setBounds(0, 0, this.f299224h, i26);
    }

    protected List<ColorClearableEditText.a> b(Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) paint);
        }
        List<ColorClearableEditText.a> d16 = f.d(this.f299225i - (((int) Math.ceil(paint.measureText(" "))) * 2), this.f299222e, paint, this.H, 16);
        d16.add(new ColorClearableEditText.a(1, 0, 0, "  ", null));
        this.f299224h = f.n(d16, paint, new Rect());
        return d16;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
        } else {
            if (i16 - i3 == 1 && this.f299223f.length() != 1 && i3 != 0) {
                return;
            }
            super.draw(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Drawable) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.G;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        if (this.G == null || (i16 - i3 == 1 && this.f299223f.length() != 1 && i3 != 0)) {
            return 0;
        }
        return this.G.getBounds().right;
    }
}
