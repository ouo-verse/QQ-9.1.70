package com.tencent.mobileqq.wink.lowthresholdltemplate;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.lowthresholdltemplate.p;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/q;", "", "Landroid/content/Context;", "context", "", IProfileCardConst.KEY_FROM_TYPE, "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p;", "b", "subCategoryId", "a", "str", "", "maxLength", "d", WadlProxyConsts.PARAM_FILENAME, "c", "e", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f323489a = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/q$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final p a(Context context, String fromType, String subCategoryId, Bundle bundle) {
        String str;
        boolean z16;
        boolean isBlank;
        p pVar = new p(fromType);
        HashMap hashMap = new HashMap();
        String v16 = WinkEditorResourceManager.a1().v1();
        Intrinsics.checkNotNullExpressionValue(v16, "getInstance().qqNickName");
        hashMap.put("nickNameForQQ", v16);
        String v17 = WinkEditorResourceManager.a1().v1();
        Intrinsics.checkNotNullExpressionValue(v17, "getInstance().qqNickName");
        hashMap.put("nickName", v17);
        hashMap.put("yearNumber", String.valueOf(Calendar.getInstance().get(1)));
        hashMap.put("monthNumber", String.valueOf(Calendar.getInstance().get(2) + 1));
        hashMap.put("dayNumber", String.valueOf(Calendar.getInstance().get(5)));
        hashMap.put("hourNumber", String.valueOf(Calendar.getInstance().get(11)));
        hashMap.put("minuteNumber", String.valueOf(Calendar.getInstance().get(12)));
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        if (bundle != null) {
            str = bundle.getString(QQWinkConstants.AVATAR_ORIGIN_HD_PATH);
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    Pair<String, Long> u16 = WinkEditorResourceManager.a1().u1();
                    if (u16 != null) {
                        str = (String) u16.first;
                    } else {
                        str = null;
                    }
                }
                if (bundle != null) {
                    str2 = bundle.getString(QQWinkConstants.AVATAR_NEW_HD_PATH);
                }
                if (str != null) {
                    arrayList.add(new kotlin.Pair(str, c(str)));
                }
                if (str2 != null) {
                    arrayList.add(new kotlin.Pair(str2, c(str2)));
                }
                int screenHeight = ViewUtils.getScreenHeight() - ViewUtils.dpToPx(370.0f);
                String string = context.getString(R.string.f238937l4);
                String string2 = context.getString(R.string.f238907l1);
                String string3 = context.getString(R.string.f238887kz);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.wink_avatar_share_window_title)");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.wink_avatar_share_save_share)");
                pVar.i(new p.UIConfig(screenHeight, string, string2, "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8913/qqavatar/qvideo_qqavatar_bg.jpg", true, false, "ae_key_editor_wink_avatar_share_sync", string3, true, 0L, 512, null));
                if (bundle != null || (r3 = bundle.getString(QQWinkConstants.WINK_PUBLISH_TASK_ID)) == null) {
                    String str3 = "";
                }
                pVar.g(new p.PublishConfig(str3, null, null, false, 14, null));
                pVar.h(new p.TemplateConfig("", "10012", subCategoryId, null, uq3.k.b().c("share_avatar_random", true), null, arrayList, hashMap, 40, null));
                HashMap hashMap2 = new HashMap();
                hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, fromType);
                pVar.f(new p.PerformanceConfig(WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_AVATAR_VIDEO_PREVIEW_PAGE, hashMap2, hashMap2, AECameraPrefsUtil.f318488z, AECameraPrefsUtil.A, WinkDengtaReportConstant.Action.AVATAR_SHARE_RES_TIME, WinkDengtaReportConstant.Action.AVATAR_SHARE_PLAYER_READY_TIME));
                return pVar;
            }
        }
        z16 = true;
        if (z16) {
        }
        if (bundle != null) {
        }
        if (str != null) {
        }
        if (str2 != null) {
        }
        int screenHeight2 = ViewUtils.getScreenHeight() - ViewUtils.dpToPx(370.0f);
        String string4 = context.getString(R.string.f238937l4);
        String string22 = context.getString(R.string.f238907l1);
        String string32 = context.getString(R.string.f238887kz);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.wink_avatar_share_window_title)");
        Intrinsics.checkNotNullExpressionValue(string22, "getString(R.string.wink_avatar_share_save_share)");
        pVar.i(new p.UIConfig(screenHeight2, string4, string22, "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8913/qqavatar/qvideo_qqavatar_bg.jpg", true, false, "ae_key_editor_wink_avatar_share_sync", string32, true, 0L, 512, null));
        if (bundle != null) {
        }
        String str32 = "";
        pVar.g(new p.PublishConfig(str32, null, null, false, 14, null));
        pVar.h(new p.TemplateConfig("", "10012", subCategoryId, null, uq3.k.b().c("share_avatar_random", true), null, arrayList, hashMap, 40, null));
        HashMap hashMap22 = new HashMap();
        hashMap22.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, fromType);
        pVar.f(new p.PerformanceConfig(WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_AVATAR_VIDEO_PREVIEW_PAGE, hashMap22, hashMap22, AECameraPrefsUtil.f318488z, AECameraPrefsUtil.A, WinkDengtaReportConstant.Action.AVATAR_SHARE_RES_TIME, WinkDengtaReportConstant.Action.AVATAR_SHARE_PLAYER_READY_TIME));
        return pVar;
    }

    private final p b(Context context, String fromType, Bundle bundle) {
        List mutableListOf;
        List mutableListOf2;
        String str;
        String string;
        Pair<String, Long> u16 = WinkEditorResourceManager.a1().u1();
        String str2 = null;
        if (u16 == null) {
            w53.b.f("WinkTemplateShareConfigFactory", "[generateSignTemplateShareConfig] qqAvatarUrlInfo is null");
            return null;
        }
        p pVar = new p(fromType);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("\u6211\u66f4\u65b0\u4e86\u4e00\u6761\u4e2a\u6027\u7b7e\u540d\uff0c\u5feb\u6765\u770b\u770b\u5427\u3002", "\u4e2a\u6027\u662f\u6211\u5e94\u6709\u7684\u6001\u5ea6\uff0c\u7b7e\u540d\u4ee3\u8868\u6211\u7684\u8bd7\u610f\u548c\u8fdc\u65b9\u3002", "\u65e0\u4e2a\u6027\u4e0d\u7b7e\u540d\uff0c\u5feb\u6765QQ\u8d44\u6599\u5361\u56f4\u89c2\u3002");
        int nextInt = Random.INSTANCE.nextInt(0, mutableListOf.size() - 1);
        HashMap hashMap = new HashMap();
        String v16 = WinkEditorResourceManager.a1().v1();
        Intrinsics.checkNotNullExpressionValue(v16, "getInstance().qqNickName");
        hashMap.put("nickNameForQQ", d(v16, 20));
        if (bundle != null && (string = bundle.getString(QQWinkConstants.WinkLowLevelTemplateShareConstant.TEMPLATE_SIGN_TEXT)) != null) {
            hashMap.put("descriptionForQQ", d(string, 100));
        }
        hashMap.put("descriptionSlogan", mutableListOf.get(nextInt));
        Object obj = u16.first;
        AppInterface e16 = com.tencent.mobileqq.wink.b.e();
        if (e16 != null) {
            str2 = e16.getCurrentUin();
        }
        Object obj2 = (Long) u16.second;
        if (obj2 == null) {
            obj2 = "default";
        }
        kotlin.Pair pair = new kotlin.Pair(obj, c(str2 + "_" + obj2 + "_qq_user_avatar"));
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(pair);
        mutableListOf2.add(pair);
        int screenHeight = ViewUtils.getScreenHeight() - ViewUtils.dpToPx(370.0f);
        String string2 = context.getString(R.string.f240957qk);
        String string3 = context.getString(R.string.f240947qj);
        String string4 = context.getString(R.string.f240937qi);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.wink_sign_share_window_title)");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.wink_sign_share_save_share)");
        pVar.i(new p.UIConfig(screenHeight, string2, string3, "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8920/dimenkan_qqfile/qqfile_mystatus_bg_v3.jpg", true, true, "ae_key_editor_wink_sign_qzone_share_sync", string4, true, 0L, 512, null));
        if (bundle == null || (str = bundle.getString(QQWinkConstants.WINK_PUBLISH_TASK_ID)) == null) {
            str = "";
        }
        pVar.g(new p.PublishConfig(str, null, null, false, 14, null));
        pVar.h(new p.TemplateConfig("moban_mystatus", "10013", "100131", null, false, null, mutableListOf2, hashMap, 56, null));
        pVar.f(new p.PerformanceConfig(WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_SIGN_VIDEO_PREVIEW_PAGE, null, null, AECameraPrefsUtil.B, AECameraPrefsUtil.C, WinkDengtaReportConstant.Action.SIGN_SHARE_RES_TIME, WinkDengtaReportConstant.Action.SIGN_SHARE_PLAYER_READY_TIME, 6, null));
        return pVar;
    }

    private final String c(String fileName) {
        String str = u53.e.f438384a + File.separator;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + System.nanoTime() + fileName;
    }

    private final String d(String str, int maxLength) {
        boolean z16;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        if (str.length() > maxLength) {
            String substring = str.substring(0, maxLength);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str;
    }

    @Nullable
    public final p e(@NotNull Context context, @NotNull String fromType, @Nullable Bundle bundle) {
        boolean areEqual;
        boolean areEqual2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        if (Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_SIGN)) {
            return b(context, fromType, bundle);
        }
        boolean z16 = true;
        if (Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_HISTORY)) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_ALBUM);
        }
        if (areEqual) {
            areEqual2 = true;
        } else {
            areEqual2 = Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_CAMERA);
        }
        if (!areEqual2) {
            z16 = Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_SUPER_QQ);
        }
        if (z16) {
            return a(context, fromType, "100121", bundle);
        }
        if (Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QCIRCLE_AVATAR)) {
            return a(context, fromType, "100122", bundle);
        }
        return null;
    }
}
