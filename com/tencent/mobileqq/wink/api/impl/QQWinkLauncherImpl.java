package com.tencent.mobileqq.wink.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.BuildParams;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.context.WinkExodus;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarStylePartFragment;
import com.tencent.mobileqq.wink.model.ModifyAvatarConfig;
import com.tencent.mobileqq.wink.newalbum.debug.NeonLightDebugFragment;
import com.tencent.mobileqq.wink.newalbum.debug.WinkNewAlbumDebugFragment;
import com.tencent.mobileqq.wink.output.QCircleWinkOutputRouterForQCircleAvatar;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.schema.WinkSchemeBean;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ^2\u00020\u0001:\u0001_B\u0007\u00a2\u0006\u0004\b\\\u0010]J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J8\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JF\u0010&\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00062\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060#j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`$2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010)\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010*\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016JG\u00100\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010/\u001a\u0004\u0018\u00010.H\u0016\u00a2\u0006\u0004\b0\u00101J \u00104\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u000eH\u0016J\"\u00106\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010\u0004H\u0016J \u00109\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00108\u001a\u0002072\u0006\u00103\u001a\u00020\u000eH\u0016J \u0010:\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u000eH\u0016J \u0010;\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u000eH\u0016J \u0010<\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u000eH\u0016J\u0018\u0010=\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\\\u0010D\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010?j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`@2\b\u0010B\u001a\u0004\u0018\u00010\u00062\b\u0010C\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016JT\u0010D\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010F\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\u0006\u0010I\u001a\u00020HH\u0016JD\u0010K\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010J\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010F\u001a\u00020\u00062\u0006\u0010I\u001a\u00020HH\u0016J\u0018\u0010L\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010M\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010Q\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010NH\u0016J(\u0010R\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010NH\u0016J\u0010\u0010S\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010T\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010U\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010V\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0016J\"\u0010X\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010W\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010[\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010Z\u001a\u00020YH\u0016\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/QQWinkLauncherImpl;", "Lcom/tencent/mobileqq/wink/api/IQQWinkLauncher;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "key", "", "fillBundleLong", "", Node.ATTRS_ATTR, "fillBundleString", "configValue", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getDayCount", "getClickCount", "getLimitHour", "Landroid/content/Intent;", "intent", "ensureWinkContext", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "traceId", "missionId", "Lcom/tencent/mobileqq/wink/context/WinkExodus;", "exodus", "Lcom/tencent/mobileqq/wink/context/WinkContext;", "businessType", "getBusinessTaskId", "getBusinessEditMode", "initialize", "preloadQQWink", "jumpToQQWinkHome", "action", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraBundle", "jumpToQQWinkBySchema", "Lcom/tencent/mobileqq/wink/QQWinkConfig;", "winkConfig", "jumpToQQWinkIndex", "jumpToWinkPublishPage", "mediaPath", "businessTransId", "businessDisplayName", "", "msgSeq", "innerBizShareToQCircle", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "oldPath", "requestCode", "jumpToAvatarPickerFragment", "extra", "jumpToMagicAvatarPickerFragment", "Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", DownloadInfo.spKey_Config, "modifyMagicAvatar", "jumpToQZoneTemplatePreviewFragment", "jumpToQZonePickerFragmentBySchema", "jumpToQZonePickerFragment", "shareToWink", "entryBusinessName", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaPaths", "textContent", "payload", "jumpToWinkEditorAfterProcessContent", "newPath", MiniAppGetGameTaskTicketServlet.KEY_TASKID, IProfileCardConst.KEY_FROM_TYPE, "", "publish", "description", "jumpToWinkEditorAfterProcessContentForQQSign", "jumpToAvatarShareWindow", "jumpToSignShareWindow", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfoList", "jumpToRecommendPreview", "jumpToWinkNewAlbumPreview", "launchWinkDebugNewAlbumActivity", "launchDebugNeonLightActivity", "jumpToTemplateLibMainPage", "fillInnerJumpBundle", QZoneDTLoginReporter.SCHEMA, "jumpToWinkTemplateIntermediate", "Landroidx/fragment/app/Fragment;", "hostFragment", "jumpSingleMediaPicker", "<init>", "()V", "Companion", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QQWinkLauncherImpl implements IQQWinkLauncher {

    @NotNull
    private static final String COUNT = "count";

    @NotNull
    private static final String DAY = "day";

    @NotNull
    private static final String HOUR = "hour";

    @NotNull
    private static final String TAG = "QQWinkLauncherImpl";
    private static final long validTime = 3600000;

    private final void ensureWinkContext(Intent intent) {
        WinkContext.Companion companion = WinkContext.INSTANCE;
        WinkContext a16 = companion.a(intent);
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, a16.getTraceId());
        companion.o(a16);
    }

    private final void fillBundleLong(Context context, Bundle bundle, String key) {
        if (context instanceof Activity) {
            bundle.putLong(key, ((Activity) context).getIntent().getLongExtra(key, -1L));
        }
    }

    private final void fillBundleString(Context context, Bundle bundle, String key, Map<String, String> attrs) {
        boolean z16;
        if (context instanceof Activity) {
            bundle.putString(key, ((Activity) context).getIntent().getStringExtra(key));
        }
        String string = bundle.getString(key);
        boolean z17 = false;
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (attrs != null && attrs.containsKey(key)) {
                z17 = true;
            }
            if (z17) {
                bundle.putString(key, attrs.get(key));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void fillBundleString$default(QQWinkLauncherImpl qQWinkLauncherImpl, Context context, Bundle bundle, String str, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        qQWinkLauncherImpl.fillBundleString(context, bundle, str, map);
    }

    private final String getBusinessEditMode(int businessType) {
        if (businessType == 10014) {
            return "1";
        }
        return "0";
    }

    private final String getBusinessTaskId(int businessType) {
        if (businessType != 1) {
            if (businessType != 10014) {
                return QCircleScheme.AttrQQPublish.BUSINESS_AIO;
            }
            return QCircleScheme.AttrQQPublish.BUSINESS_GUILD;
        }
        return QCircleScheme.AttrQQPublish.BUSINESS_TROOP;
    }

    private final int getClickCount(String configValue, int defaultValue) {
        try {
            return new JSONObject(configValue).optInt("count");
        } catch (JSONException e16) {
            e16.printStackTrace();
            return defaultValue;
        }
    }

    private final int getDayCount(String configValue, int defaultValue) {
        try {
            return new JSONObject(configValue).optInt(DAY);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return defaultValue;
        }
    }

    private final int getLimitHour(String configValue, int defaultValue) {
        try {
            return new JSONObject(configValue).optInt("hour");
        } catch (JSONException e16) {
            e16.printStackTrace();
            return defaultValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void modifyMagicAvatar$lambda$2() {
        QQToast.makeText(BaseApplication.getContext(), "\u8d44\u6e90\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    @NotNull
    public Bundle fillInnerJumpBundle(@NotNull Context context, @Nullable Map<String, String> attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        fillBundleString$default(this, context, bundle, QQWinkConstants.KEY_PREVIOUS_ACTIVITY, null, 8, null);
        fillBundleString$default(this, context, bundle, "PhotoConst.INIT_ACTIVITY_CLASS_NAME", null, 8, null);
        fillBundleString$default(this, context, bundle, PeakConstants.DEST_ACTIVITY_CLASS_NAME, null, 8, null);
        fillBundleString$default(this, context, bundle, QQWinkConstants.ENTRY_BUSINESS_NAME, null, 8, null);
        fillBundleString$default(this, context, bundle, "app_key", null, 8, null);
        fillBundleString(context, bundle, "tagtitle", attrs);
        fillBundleString(context, bundle, "taguin", attrs);
        fillBundleString(context, bundle, "adId", attrs);
        fillBundleString$default(this, context, bundle, "wink_output_route", null, 8, null);
        fillBundleLong(context, bundle, "wink_output_point");
        return bundle;
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void initialize() {
        Wink.INSTANCE.d(new ca3.g(), new ca3.a(), new ca3.b(), new ca3.d(), new ca3.c(), new ca3.f());
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void innerBizShareToQCircle(@NotNull Context context, @Nullable String mediaPath, int businessType, @Nullable String businessTransId, @Nullable String businessDisplayName, @Nullable Long msgSeq) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (mediaPath != null && mediaPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w53.b.f(TAG, "[jumpToWinkEditorPage] mediaPath is empty");
            return;
        }
        String str = "mqqapi://qcircle/openqqpublish?target=3&mediapath=" + mediaPath + "&exit_dialog=1&taskid=" + getBusinessTaskId(businessType) + "&business_trans_id=" + businessTransId + "&business_display_name=" + businessDisplayName + "&edit_image_mode=" + getBusinessEditMode(businessType) + "&business_aio_message_seq=" + msgSeq;
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(str));
        context.startActivity(intent);
        w53.b.a(TAG, "[jumpToWinkEditorPage] businessTransId=" + businessTransId + ", mediaPath=" + mediaPath);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpSingleMediaPicker(@NotNull Context context, @NotNull Fragment hostFragment) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        ensureWinkContext(bundle);
        com.tencent.mobileqq.wink.picker.f fVar = com.tencent.mobileqq.wink.picker.f.f324854a;
        String traceId = WinkContext.INSTANCE.d().getTraceId();
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar = new Config.a();
        aVar.i(TabType.ALL_MEDIA);
        aVar.f(true);
        aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
        aVar.e(100);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wink.picker.f.b(fVar, context, hostFragment, 100, traceId, aVar.a(), null, 32, null);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToAvatarPickerFragment(@NotNull Context context, @NotNull String oldPath, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oldPath, "oldPath");
        com.tencent.mobileqq.wink.picker.f.f324854a.d(context, oldPath, requestCode, ensureWinkContext("QCIRCLE", WinkContext.INSTANCE.g(), null, null).getTraceId());
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToAvatarShareWindow(@NotNull Context context, @NotNull Bundle bundle) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return;
        }
        int d16 = AECameraPrefsUtil.c().d(AECameraPrefsUtil.f318488z, 0, 0);
        long e16 = AECameraPrefsUtil.c().e(AECameraPrefsUtil.A, 0L, 0);
        String configValue = QzoneConfig.getApplyAvatarVideoControl();
        Intrinsics.checkNotNullExpressionValue(configValue, "configValue");
        long dayCount = (getDayCount(configValue, 7) * 86400000) + e16;
        int clickCount = getClickCount(configValue, 3);
        if (e16 + (getLimitHour(configValue, 2) * 3600000) > System.currentTimeMillis() || (d16 >= clickCount && dayCount >= System.currentTimeMillis())) {
            z16 = false;
        } else {
            if (d16 >= clickCount) {
                AECameraPrefsUtil.c().i(AECameraPrefsUtil.f318488z, 0, 0);
            }
            z16 = true;
        }
        if (z16 || com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_AVATAR_SHARE_WINDOW_KEY, 0)) {
            ensureWinkContext(bundle);
            com.tencent.mobileqq.wink.g.f322861a.h(context, bundle);
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToMagicAvatarPickerFragment(@NotNull Context context, int requestCode, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        WinkContext ensureWinkContext = ensureWinkContext("QCIRCLE", WinkContext.INSTANCE.g(), null, null);
        com.tencent.mobileqq.wink.picker.f fVar = com.tencent.mobileqq.wink.picker.f.f324854a;
        String traceId = ensureWinkContext.getTraceId();
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar = new Config.a();
        aVar.i(TabType.ONLY_IMAGE);
        aVar.f(true);
        aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
        aVar.e(101);
        Unit unit = Unit.INSTANCE;
        fVar.e(context, null, requestCode, traceId, aVar.a(), extra);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToQQWinkBySchema(@NotNull Context context, @NotNull String action, @NotNull HashMap<String, String> attrs, @Nullable Bundle extraBundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        WinkSchemeBean winkSchemeBean = new WinkSchemeBean();
        winkSchemeBean.setSchemeAction(action);
        winkSchemeBean.setAttrs(attrs);
        com.tencent.mobileqq.wink.schema.b.b(context, winkSchemeBean, extraBundle);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToQQWinkHome(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ensureWinkContext(bundle);
        com.tencent.mobileqq.wink.g.f322861a.d(context, bundle);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToQQWinkIndex(@NotNull Context context, @NotNull QQWinkConfig winkConfig, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(winkConfig, "winkConfig");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ensureWinkContext(bundle);
        com.tencent.mobileqq.wink.index.i.f322938a.e(context, winkConfig, bundle);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToQZonePickerFragment(@NotNull Context context, @NotNull Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ensureWinkContext(intent);
        com.tencent.mobileqq.wink.picker.f.f324854a.i(context, intent, requestCode);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToQZonePickerFragmentBySchema(@NotNull Context context, @NotNull Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ensureWinkContext(intent);
        intent.putExtra("param_parse_schema_params", true);
        com.tencent.mobileqq.wink.picker.f.f324854a.j(context, intent, 0, new ArrayList(), requestCode);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToQZoneTemplatePreviewFragment(@NotNull Context context, @NotNull Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ensureWinkContext(intent);
        com.tencent.mobileqq.wink.g.f322861a.e(context, intent, requestCode);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToRecommendPreview(@NotNull Context context, @NotNull Bundle bundle, @Nullable List<? extends LocalMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ensureWinkContext(bundle);
        com.tencent.mobileqq.wink.g.f322861a.f(context, bundle, mediaInfoList);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToSignShareWindow(@NotNull Context context, @NotNull Bundle bundle) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return;
        }
        int d16 = AECameraPrefsUtil.c().d(AECameraPrefsUtil.B, 0, 0);
        long e16 = AECameraPrefsUtil.c().e(AECameraPrefsUtil.C, 0L, 0);
        String configValue = QzoneConfig.getApplySignVideoControl();
        Intrinsics.checkNotNullExpressionValue(configValue, "configValue");
        long dayCount = (getDayCount(configValue, 7) * 86400000) + e16;
        int clickCount = getClickCount(configValue, 3);
        if (e16 + (getLimitHour(configValue, 2) * 3600000) > System.currentTimeMillis() || (d16 >= clickCount && dayCount >= System.currentTimeMillis())) {
            z16 = false;
        } else {
            if (d16 >= clickCount) {
                AECameraPrefsUtil.c().i(AECameraPrefsUtil.B, 0, 0);
            }
            z16 = true;
        }
        if (z16 || com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_AVATAR_SHARE_WINDOW_KEY, 0)) {
            ensureWinkContext(bundle);
            com.tencent.mobileqq.wink.g.f322861a.h(context, bundle);
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToTemplateLibMainPage(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.putString("AECAMERA_TAB_SELECTED", "2");
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_TEMPLATE_TAB, true);
        bundle.putBoolean("ARG_PADDING_BOTTOM", false);
        jumpToQQWinkHome(context, bundle);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToWinkEditorAfterProcessContent(@NotNull Context context, @NotNull String entryBusinessName, @Nullable String missionId, @Nullable ArrayList<String> mediaPaths, @Nullable String textContent, @Nullable Bundle payload, @Nullable String traceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entryBusinessName, "entryBusinessName");
        Intrinsics.checkNotNull(payload);
        WinkExodus winkExodus = new WinkExodus(payload.getString("wink_output_route"), payload.getLong("wink_output_point"));
        if (traceId == null) {
            traceId = WinkContext.INSTANCE.g();
        }
        WinkContext ensureWinkContext = ensureWinkContext(entryBusinessName, traceId, missionId, winkExodus);
        com.tencent.mobileqq.wink.g.f322861a.k(context, entryBusinessName, ensureWinkContext.getMissionId(), mediaPaths, textContent, payload, ensureWinkContext.getTraceId());
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToWinkEditorAfterProcessContentForQQSign(@NotNull Context context, @NotNull String entryBusinessName, @Nullable String missionId, @NotNull String description, @Nullable String traceId, @NotNull String taskId, boolean publish) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entryBusinessName, "entryBusinessName");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        WinkExodus winkExodus = new WinkExodus(QCircleWinkOutputRouterForQCircleAvatar.ROUTE_PATH, 2L);
        if (traceId == null) {
            traceId = WinkContext.INSTANCE.g();
        }
        WinkContext ensureWinkContext = ensureWinkContext(entryBusinessName, traceId, missionId, winkExodus);
        com.tencent.mobileqq.wink.g.f322861a.l(context, entryBusinessName, ensureWinkContext.getMissionId(), description, ensureWinkContext.getTraceId(), taskId, publish);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToWinkNewAlbumPreview(@NotNull Context context, @NotNull Bundle bundle, @Nullable List<? extends LocalMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ensureWinkContext(bundle);
        com.tencent.mobileqq.wink.f.z(context, bundle, new ArrayList(mediaInfoList));
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToWinkPublishPage(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ensureWinkContext(intent);
        com.tencent.mobileqq.wink.g.f322861a.m(context, intent);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToWinkTemplateIntermediate(@NotNull Context context, @NotNull Intent intent, @Nullable String schema) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.mobileqq.wink.g.f322861a.o(context, intent, schema);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void launchDebugNeonLightActivity(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", NeonLightDebugFragment.class.getName());
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, UUID.randomUUID().toString());
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        ensureWinkContext(intent);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void launchWinkDebugNewAlbumActivity(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", WinkNewAlbumDebugFragment.class.getName());
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, UUID.randomUUID().toString());
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        ensureWinkContext(intent);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void modifyMagicAvatar(@NotNull Context context, @NotNull ModifyAvatarConfig config, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady(QQWinkConstants.ENTRY_QQ_WORLD, true)) {
            com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    QQWinkLauncherImpl.modifyMagicAvatar$lambda$2();
                }
            });
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("public_fragment_window_feature", 1);
        config.setRequestCode(1000);
        bundle.putParcelable("avatar_config", config);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        boolean z16 = context instanceof Activity;
        if (!z16) {
            intent.addFlags(268435456);
        }
        WinkContext ensureWinkContext = ensureWinkContext("QCIRCLE", WinkContext.INSTANCE.g(), null, null);
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", MagicAvatarStylePartFragment.class.getName());
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, ensureWinkContext.getTraceId());
        if (z16) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        } else {
            context.startActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void preloadQQWink(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.wink.g.f322861a.p(context);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void shareToWink(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ensureWinkContext(bundle);
        com.tencent.mobileqq.wink.g.f322861a.q(context, bundle);
    }

    private final void ensureWinkContext(Bundle bundle) {
        WinkContext.Companion companion = WinkContext.INSTANCE;
        WinkContext b16 = companion.b(bundle);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, b16.getTraceId());
        companion.o(b16);
    }

    private final WinkContext ensureWinkContext(String businessName, String traceId, String missionId, WinkExodus exodus) {
        BuildParams buildParams = new BuildParams(businessName, traceId, missionId, null, null, exodus);
        WinkContext.Companion companion = WinkContext.INSTANCE;
        WinkContext c16 = companion.c(buildParams);
        companion.o(c16);
        return c16;
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkLauncher
    public void jumpToWinkEditorAfterProcessContent(@NotNull Context context, @NotNull String entryBusinessName, @Nullable String missionId, @NotNull String oldPath, @NotNull String newPath, @Nullable String traceId, @NotNull String taskId, @NotNull String fromType, boolean publish) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entryBusinessName, "entryBusinessName");
        Intrinsics.checkNotNullParameter(oldPath, "oldPath");
        Intrinsics.checkNotNullParameter(newPath, "newPath");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        WinkContext ensureWinkContext = ensureWinkContext(entryBusinessName, traceId == null ? WinkContext.INSTANCE.g() : traceId, missionId, new WinkExodus(QCircleWinkOutputRouterForQCircleAvatar.ROUTE_PATH, 2L));
        com.tencent.mobileqq.wink.g.f322861a.j(context, entryBusinessName, ensureWinkContext.getMissionId(), oldPath, newPath, ensureWinkContext.getTraceId(), taskId, fromType, publish);
    }
}
