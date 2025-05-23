package com.tencent.mobileqq.poke;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.NTPEItemData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0006R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017R(\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R2\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000e0-j\b\u0012\u0004\u0012\u00020\u000e`.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010=\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010<R$\u0010C\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010?\u001a\u0004\b#\u0010@\"\u0004\bA\u0010BR\"\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u00105\u001a\u0004\b\u001d\u00107\"\u0004\bD\u00109R\"\u0010G\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u00105\u001a\u0004\b \u00107\"\u0004\bF\u00109\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/poke/c;", "", "", "peOders", "", "a", "", "l", "", "emoid", "c", "j", "orderInfo", "", "Lcom/tencent/mobileqq/data/NTPEItemData;", tl.h.F, "Landroid/graphics/drawable/Drawable;", "b", "idx", "d", "k", "Ljava/lang/String;", "getPE_PATH", "()Ljava/lang/String;", "PE_PATH", "getPE_EMO_PATH", "PE_EMO_PATH", "i", "PE_LOTTIE_PATH", "e", "getPE_FONT_PATH", "PE_FONT_PATH", "f", "getPE_SUMMARY_PATH", "PE_SUMMARY_PATH", "g", "getPE_FONT_FILE_PATH", "PE_FONT_FILE_PATH", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "getPeItemDataArrayList", "()Landroid/util/SparseArray;", "setPeItemDataArrayList", "(Landroid/util/SparseArray;)V", "peItemDataArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getUiPEItemDataArrayList", "()Ljava/util/ArrayList;", "setUiPEItemDataArrayList", "(Ljava/util/ArrayList;)V", "uiPEItemDataArrayList", "Z", "isResLoaded", "()Z", "setResLoaded", "(Z)V", "getMOrderInfo", "setMOrderInfo", "(Ljava/lang/String;)V", "mOrderInfo", "Landroid/graphics/Typeface;", "Landroid/graphics/Typeface;", "()Landroid/graphics/Typeface;", "setMTypeface", "(Landroid/graphics/Typeface;)V", "mTypeface", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mIsLottiePlayed", DomainData.DOMAIN_NAME, "mIsTypefaceLoading", "<init>", "()V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f258994a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PE_PATH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PE_EMO_PATH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PE_LOTTIE_PATH;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PE_FONT_PATH;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PE_SUMMARY_PATH;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PE_FONT_FILE_PATH;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SparseArray<String> peItemDataArrayList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<NTPEItemData> uiPEItemDataArrayList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isResLoaded;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String mOrderInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Typeface mTypeface;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsLottiePlayed;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean mIsTypefaceLoading;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29051);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
            return;
        }
        f258994a = new c();
        String str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PE) + File.separator;
        PE_PATH = str;
        PE_EMO_PATH = str + "res/";
        PE_LOTTIE_PATH = str + "lottie/";
        String str2 = str + "font/";
        PE_FONT_PATH = str2;
        PE_SUMMARY_PATH = str + "summary/";
        PE_FONT_FILE_PATH = str2 + "sticker_bubble_animation.ttf";
        peItemDataArrayList = new SparseArray<>();
        uiPEItemDataArrayList = new ArrayList<>();
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@Nullable String peOders) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) peOders)).booleanValue();
        }
        String str = PE_PATH;
        if (!new File(str).exists()) {
            return false;
        }
        com.tencent.mobileqq.poke.utils.b.f259090a.a(str);
        if (TextUtils.isEmpty(peOders)) {
            return false;
        }
        Intrinsics.checkNotNull(peOders);
        Object[] array = new Regex(",").split(peOders, 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16)) {
            return true;
        }
        boolean z17 = true;
        for (String str2 : strArr) {
            try {
            } catch (Exception e16) {
                QLog.d("PokeEmo", 1, "checkPEResValid + exception :" + e16);
                z17 = false;
            }
            if (!new File(j(Integer.parseInt(str2))).exists()) {
                return false;
            }
        }
        return z17;
    }

    @NotNull
    public final Drawable b(int emoid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Drawable) iPatchRedirector.redirect((short) 29, (Object) this, emoid);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        String j3 = j(emoid);
        obtain.mPlayGifImage = true;
        obtain.mLoadingDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(R.drawable.d3s);
        obtain.mFailedDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(R.drawable.d3s);
        URLDrawable b16 = URLDrawable.getDrawable(new File(j3), obtain);
        if (b16.getStatus() == 2) {
            b16.restartDownload();
        }
        Intrinsics.checkNotNullExpressionValue(b16, "b");
        return b16;
    }

    @NotNull
    public final String c(int emoid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this, emoid);
        }
        if (peItemDataArrayList.size() == 0) {
            l();
        }
        String str = peItemDataArrayList.get(emoid);
        if (TextUtils.isEmpty(str)) {
            return HardCodeUtil.qqStr(R.string.p0a);
        }
        return str;
    }

    @Nullable
    public final NTPEItemData d(int idx) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (NTPEItemData) iPatchRedirector.redirect((short) 30, (Object) this, idx);
        }
        if (uiPEItemDataArrayList.size() > idx) {
            return uiPEItemDataArrayList.get(idx);
        }
        return null;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return mIsLottiePlayed;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return mIsTypefaceLoading;
    }

    @Nullable
    public final Typeface g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Typeface) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return mTypeface;
    }

    @NotNull
    public final List<NTPEItemData> h(@Nullable String orderInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, (Object) this, (Object) orderInfo);
        }
        if (orderInfo != null && Intrinsics.areEqual(orderInfo, mOrderInfo)) {
            return uiPEItemDataArrayList;
        }
        uiPEItemDataArrayList.clear();
        if (!TextUtils.isEmpty(orderInfo)) {
            Intrinsics.checkNotNull(orderInfo);
            Object[] array = new Regex(",").split(orderInfo, 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (String str : strArr) {
                    try {
                        int parseInt = Integer.parseInt(str);
                        NTPEItemData nTPEItemData = new NTPEItemData();
                        nTPEItemData.setPokeEmoId(parseInt);
                        nTPEItemData.setLocalPath(j(parseInt));
                        uiPEItemDataArrayList.add(nTPEItemData);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
        return uiPEItemDataArrayList;
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return PE_LOTTIE_PATH;
    }

    @NotNull
    public final String j(int emoid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, emoid);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%spe_%d.gif", Arrays.copyOf(new Object[]{PE_EMO_PATH, Integer.valueOf(emoid)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (mTypeface != null) {
            return;
        }
        try {
            String str = PE_FONT_FILE_PATH;
            File file = new File(str);
            if (file.exists()) {
                mTypeface = Typeface.createFromFile(file);
                QLog.e("PokeEmo", 1, "loadFont success " + str + " is exist");
            } else {
                QLog.e("PokeEmo", 1, "loadFont failed " + str + " is not exist");
            }
        } catch (Exception e16) {
            QLog.e("PokeEmo", 1, "loadFont failed " + e16.getMessage());
            mTypeface = null;
            mIsTypefaceLoading = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0059 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void l() {
        boolean z16;
        String str;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (isResLoaded) {
            return;
        }
        File file = new File(PE_SUMMARY_PATH);
        if (!file.exists()) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            if (listFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                try {
                    bArr = FileUtils.getByte(listFiles[0]);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (bArr != null) {
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    str = new String(bArr, UTF_8);
                    if (!TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        Iterator keys = jSONObject.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "summaryJson.keys()");
                        while (keys.hasNext()) {
                            Object next = keys.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) next;
                            Object obj = jSONObject.get(str2);
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            peItemDataArrayList.put(Integer.parseInt(str2), (String) obj);
                        }
                        isResLoaded = true;
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                }
                str = null;
                if (!TextUtils.isEmpty(str)) {
                }
            }
        }
    }

    public final void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            mIsLottiePlayed = z16;
        }
    }

    public final void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            mIsTypefaceLoading = z16;
        }
    }
}
