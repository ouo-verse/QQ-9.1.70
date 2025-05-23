package com.tencent.biz.qqcircle.immersive.personal.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.model.ModifyAvatarConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StIconInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleProfile$StModifyLimitItem;
import qqcircle.QQCircleProfile$StProfileBizData;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010J\u0006\u0010\u0014\u001a\u00020\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/utils/QFSMagicAvatarModifyUtils;", "", "Lcom/tencent/biz/qqcircle/immersive/personal/data/w;", "userInfoData", "", "g", "Lqqcircle/QQCircleProfile$StModifyLimitItem;", "e", "c", "Landroid/content/Context;", "context", "", tl.h.F, "i", "", "id", "", "stModifyLimitItems", "d", "", "f", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMagicAvatarModifyUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSMagicAvatarModifyUtils f89040a = new QFSMagicAvatarModifyUtils();

    QFSMagicAvatarModifyUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c() {
        String o26 = uq3.c.o2();
        Intrinsics.checkNotNullExpressionValue(o26, "getMagicVipRequestUrl()");
        return o26;
    }

    private final QQCircleProfile$StModifyLimitItem e(w userInfoData) {
        QQCircleProfile$StProfileBizData g16;
        byte[] byteArray;
        QQCircleProfile$StProfileBizData qQCircleProfile$StProfileBizData = new QQCircleProfile$StProfileBizData();
        List<QQCircleProfile$StModifyLimitItem> list = null;
        if (userInfoData != null) {
            try {
                g16 = userInfoData.g();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QFSPersonalEditViewModel", 1, "initData... exception:", e16);
            }
            if (g16 != null) {
                byteArray = g16.toByteArray();
                qQCircleProfile$StProfileBizData.mergeFrom(byteArray);
                list = qQCircleProfile$StProfileBizData.modifyLimitFields.get();
                return d(10025, list);
            }
        }
        byteArray = null;
        qQCircleProfile$StProfileBizData.mergeFrom(byteArray);
        list = qQCircleProfile$StProfileBizData.modifyLimitFields.get();
        return d(10025, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(w userInfoData) {
        String str;
        FeedCloudMeta$StUser c16;
        FeedCloudMeta$StIconInfo feedCloudMeta$StIconInfo;
        PBStringField pBStringField;
        FeedCloudMeta$StUser c17;
        FeedCloudMeta$StIconInfo feedCloudMeta$StIconInfo2;
        PBStringField pBStringField2;
        FeedCloudMeta$StUser c18;
        FeedCloudMeta$StIconInfo feedCloudMeta$StIconInfo3;
        PBStringField pBStringField3;
        String str2 = null;
        if (userInfoData != null && (c18 = userInfoData.c()) != null && (feedCloudMeta$StIconInfo3 = c18.icon) != null && (pBStringField3 = feedCloudMeta$StIconInfo3.iconUrl640) != null) {
            str = pBStringField3.get();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (userInfoData != null && (c17 = userInfoData.c()) != null && (feedCloudMeta$StIconInfo2 = c17.icon) != null && (pBStringField2 = feedCloudMeta$StIconInfo2.iconUrl640) != null) {
                str2 = pBStringField2.get();
            }
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        if (userInfoData != null && (c16 = userInfoData.c()) != null && (feedCloudMeta$StIconInfo = c16.icon) != null && (pBStringField = feedCloudMeta$StIconInfo.iconUrl) != null) {
            str2 = pBStringField.get();
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Nullable
    public final QQCircleProfile$StModifyLimitItem d(int id5, @Nullable List<QQCircleProfile$StModifyLimitItem> stModifyLimitItems) {
        if (stModifyLimitItems == null) {
            return null;
        }
        int size = stModifyLimitItems.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (stModifyLimitItems.get(i3).type.get() == id5) {
                return stModifyLimitItems.get(i3);
            }
        }
        return null;
    }

    public final boolean f() {
        return uq3.k.a().c("qfs_share_avatar_video_to_xsj", false);
    }

    public final void h(@NotNull final Context context, @Nullable final w userInfoData) {
        final int i3;
        PBInt32Field pBInt32Field;
        PBInt32Field pBInt32Field2;
        Intrinsics.checkNotNullParameter(context, "context");
        QQCircleProfile$StModifyLimitItem e16 = e(userInfoData);
        int i16 = 0;
        if (e16 != null && (pBInt32Field2 = e16.totalNum) != null) {
            i3 = pBInt32Field2.get();
        } else {
            i3 = 0;
        }
        if (e16 != null && (pBInt32Field = e16.allowNum) != null) {
            i16 = pBInt32Field.get();
        }
        final int i17 = i16;
        final String valueOf = String.valueOf(i3);
        final String f16 = g.f();
        QLog.d("MAI-QFSMagicAvatarModifyUtils", 1, "[modifyAvatarConfig] totalNum:" + i3 + " | allowNum:" + i17 + " | nextMonthTime:" + f16);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.QFSMagicAvatarModifyUtils$modifyAvatarConfig$1
            @Override // java.lang.Runnable
            public void run() {
                String g16;
                String str;
                String str2;
                FeedCloudMeta$StUser c16;
                PBStringField pBStringField;
                boolean z16;
                String string;
                String c17;
                QFSMagicAvatarModifyUtils qFSMagicAvatarModifyUtils = QFSMagicAvatarModifyUtils.f89040a;
                g16 = qFSMagicAvatarModifyUtils.g(w.this);
                if (!TextUtils.isEmpty(g16)) {
                    Option obtain = Option.obtain();
                    obtain.setUrl(g16);
                    str2 = QCircleFeedPicLoader.g().getPicLocalPath(obtain);
                    Intrinsics.checkNotNullExpressionValue(str2, "g().getPicLocalPath(option)");
                } else {
                    w wVar = w.this;
                    if (wVar != null && (c16 = wVar.c()) != null && (pBStringField = c16.f398463id) != null) {
                        str = pBStringField.get();
                    } else {
                        str = null;
                    }
                    HostFaceUtils.getAvatarDownloadUrl(str);
                    str2 = "";
                }
                ModifyAvatarConfig modifyAvatarConfig = new ModifyAvatarConfig();
                if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_avatarVideo")) {
                    z16 = qFSMagicAvatarModifyUtils.f();
                } else {
                    z16 = true;
                }
                modifyAvatarConfig.setSelectShareByDefault(z16);
                modifyAvatarConfig.setShowShare(!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
                boolean z17 = false;
                modifyAvatarConfig.setAvatarSource(0);
                String d16 = com.dataline.util.j.d(context.getResources().getString(R.string.f19152451));
                Intrinsics.checkNotNullExpressionValue(d16, "replaceToDynamicNameText\u2026.qfs_magic_avatar_share))");
                modifyAvatarConfig.setShareTipsText(d16);
                if (i17 > 0) {
                    string = "";
                } else {
                    string = context.getResources().getString(R.string.f19153452, valueOf, f16);
                    Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026nthTime\n                )");
                }
                modifyAvatarConfig.setModifyAvatarErrorMessage(string);
                if (g16 == null) {
                    g16 = "";
                }
                modifyAvatarConfig.setCurrentAvatarUrl(g16);
                modifyAvatarConfig.setOldAvatarFilePath(str2);
                modifyAvatarConfig.setRequestCode(1000);
                if (i17 > 0) {
                    z17 = true;
                }
                modifyAvatarConfig.setModifyChancesUsedUp(z17);
                c17 = qFSMagicAvatarModifyUtils.c();
                modifyAvatarConfig.setOpenVipSchema(c17);
                modifyAvatarConfig.setMagicAvatarDelegateClassName(h.class.getName());
                uq3.k.a().m("magic_avatar_allow_num", i17);
                uq3.k.a().m("magic_avatar_total_num", i3);
                QRouteApi api = QRoute.api(IQQWinkLauncher.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IQQWinkLauncher::class.java)");
                IQQWinkLauncher.DefaultImpls.modifyMagicAvatar$default((IQQWinkLauncher) api, context, modifyAvatarConfig, 0, 4, null);
                QLog.d("MAI-QFSMagicAvatarModifyUtils", 1, "[modifyAvatarConfig] click modify avatar config, selectShareByDefault=" + modifyAvatarConfig.getSelectShareByDefault() + " | showShare=" + modifyAvatarConfig.getShowShare() + " | avatarSource=" + modifyAvatarConfig.getAvatarSource() + " | shareTipsText=" + modifyAvatarConfig.getShareTipsText() + " | magicAvatarDelegateClassName=" + modifyAvatarConfig.getMagicAvatarDelegateClassName() + " | currentAvatarUrl=" + modifyAvatarConfig.getCurrentAvatarUrl() + " | requestCode=" + modifyAvatarConfig.getRequestCode() + " | oldAvatarFilePath=" + modifyAvatarConfig.getOldAvatarFilePath() + " | modifyChancesUsedUp=" + modifyAvatarConfig.getModifyChancesUsedUp() + " | openVipSchema=" + modifyAvatarConfig.getOpenVipSchema());
            }
        });
    }

    public final void i(@Nullable w userInfoData) {
        Integer num;
        PBInt32Field pBInt32Field;
        PBInt32Field pBInt32Field2;
        QQCircleProfile$StModifyLimitItem e16 = e(userInfoData);
        Integer num2 = null;
        if (e16 != null && (pBInt32Field2 = e16.totalNum) != null) {
            num = Integer.valueOf(pBInt32Field2.get());
        } else {
            num = null;
        }
        if (e16 != null && (pBInt32Field = e16.allowNum) != null) {
            num2 = Integer.valueOf(pBInt32Field.get());
        }
        QLog.d("MAI-QFSMagicAvatarModifyUtils", 1, "[printAvatarConfig] modifyLimitItem totalNum: " + num + " | allowNum:" + num2);
    }
}
