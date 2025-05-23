package com.tencent.mobileqq.wink.magicstudio.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import b93.OutputData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioLogicFragment;
import com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment;
import com.tencent.mobileqq.wink.magicstudio.WinkMagicStudioResultFragment;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioHistoryImageModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.share.WinkShareManager;
import com.tencent.mobileqq.wink.share.c;
import com.tencent.mobileqq.wink.view.al;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import e93.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import qshadow.ShadowAIGCStatus$GetStatusReply;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bp\u0010qJ>\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J>\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J8\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002JB\u0010%\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J$\u0010(\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u009c\u0001\u00107\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010-\u001a\u0004\u0018\u00010\b2\u0006\u0010.\u001a\u00020\u001b2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u001d2\u001e\u00104\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b03\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000b022\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0010\u00109\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u00010\bJu\u0010E\u001a\u00020\u000b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:032\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010<\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010@\u001a\u0016\u0012\u0004\u0012\u00020>\u0018\u00010=j\n\u0012\u0004\u0012\u00020>\u0018\u0001`?2\u0006\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010\u001d2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001b\u00a2\u0006\u0004\bE\u0010FJ\\\u0010G\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ8\u0010L\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020/2\b\u0010K\u001a\u0004\u0018\u00010J2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ6\u0010Q\u001a\u00020\u001d2\b\u0010N\u001a\u0004\u0018\u00010M2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010R\u001a\u00020\u001bJ1\u0010Z\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020S2!\u0010Y\u001a\u001d\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\u000b0UJ&\u0010[\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010^\u001a\u00020\u000b2\b\u0010\\\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u001bR\"\u0010e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010i\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010`\u001a\u0004\bg\u0010b\"\u0004\bh\u0010dR\"\u0010o\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/utils/WinkMagicStudioLogicUtils;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magicStudioPicStyle", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "buttonInfo", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategory", "Lkotlin/Function0;", "", "handleActionType", "l", "shareCallback", "handleCreate", "e", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioHistoryImageModel;", "historyImageModel", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "magicStudioCreationViewModel", "f", "Lcom/tencent/mobileqq/wink/share/c;", "shareModel", "w", "", "j", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "privacyTitle", "privacyContent", "privacyUrl", "positiveCallBack", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "i", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "magicStyleMaterial", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "buttonInfoResp", "shareInfoCategory", "imagePath", "", "generationCount", "regenerate", "Lkotlin/Function2;", "", "successCallback", "failedCallback", "cancelCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "shareCategory", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "picMode", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "Lkotlin/collections/ArrayList;", "generateInfos", "regenerateCount", "publishWithOriginImage", "styleId", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "k", "(Ljava/util/List;Landroid/app/Activity;ZLcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;Ljava/util/ArrayList;ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", DomainData.DOMAIN_NAME, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "v", "Landroid/view/View;", "btnView", "onCreateCallback", "onShareCallback", "p", "u", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "callback", "d", "g", QZoneDTLoginReporter.SCHEMA, "src", "r", "b", "Z", h.F, "()Z", "setNeedReopenAlbumFromMultiSelectFragment", "(Z)V", "needReopenAlbumFromMultiSelectFragment", "c", "getShareIsShowing", "y", "shareIsShowing", "Ljava/lang/String;", "getShareInfoJson", "()Ljava/lang/String;", "setShareInfoJson", "(Ljava/lang/String;)V", "shareInfoJson", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMagicStudioLogicUtils {

    /* renamed from: b, reason: from kotlin metadata */
    private static boolean needReopenAlbumFromMultiSelectFragment;

    /* renamed from: c, reason: from kotlin metadata */
    private static boolean shareIsShowing;

    /* renamed from: a */
    @NotNull
    public static final WinkMagicStudioLogicUtils f323883a = new WinkMagicStudioLogicUtils();

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static String shareInfoJson = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/utils/WinkMagicStudioLogicUtils$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a */
        final /* synthetic */ Function1<Boolean, Unit> f323887a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Boolean, Unit> function1) {
            this.f323887a = function1;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f323887a.invoke(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> r26) {
            super.onDenied(permissions, r26);
            this.f323887a.invoke(Boolean.FALSE);
        }
    }

    WinkMagicStudioLogicUtils() {
    }

    public final void A() {
        AECameraPrefsUtil.c().h(r93.h.f430993a.f(), true, 0);
    }

    public final void e(Activity r46, MagicStudioPicStyle magicStudioPicStyle, MagicStudioButtonInfo buttonInfo, Function0<Unit> shareCallback, Function0<Unit> handleCreate) {
        int actionType = buttonInfo.getActionType();
        if (actionType != 1) {
            if (actionType != 2) {
                if (actionType == 3) {
                    handleCreate.invoke();
                    return;
                }
                return;
            }
            g(r46, magicStudioPicStyle, shareCallback);
            return;
        }
        s(this, buttonInfo.getSchemaUrl(), null, 2, null);
    }

    public final void f(Activity r95, Fragment fragment, MagicStudioPicStyle magicStudioPicStyle, MagicStudioHistoryImageModel historyImageModel, MagicStudioCreationViewModel magicStudioCreationViewModel) {
        if (magicStudioCreationViewModel != null && historyImageModel != null) {
            needReopenAlbumFromMultiSelectFragment = false;
            if (com.tencent.mobileqq.wink.editor.util.h.f322638a.c()) {
                if (r95 instanceof FragmentActivity) {
                    LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                    localMediaInfo.path = historyImageModel.getImagePath();
                    ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).launchMagicStudioResultFragment((FragmentActivity) r95, MagicStudioCreationViewModel.INSTANCE.a(magicStudioPicStyle, localMediaInfo, false));
                    return;
                }
                return;
            }
            MagicStudioCreationViewModel.q3(magicStudioCreationViewModel, historyImageModel.getImagePath(), magicStudioPicStyle, false, null, 0, 28, null);
            return;
        }
        needReopenAlbumFromMultiSelectFragment = true;
        t(r95, fragment, magicStudioPicStyle);
    }

    private final boolean i() {
        return AECameraPrefsUtil.c().b(r93.h.f430993a.f(), false, 0);
    }

    private final String j(MagicStudioPicStyle magicStudioPicStyle) {
        if (magicStudioPicStyle != null && com.tencent.mobileqq.wink.editor.util.h.f322638a.g()) {
            return magicStudioPicStyle.getMaterialId();
        }
        return "magic_studio_share_info";
    }

    private final void l(Activity r75, MagicStudioPicStyle magicStudioPicStyle, MagicStudioButtonInfo buttonInfo, MetaCategory metaCategory, final Function0<Unit> handleActionType) {
        String str;
        String str2;
        if (magicStudioPicStyle != null && buttonInfo != null) {
            if (FastClickUtils.isFastDoubleClick("WinkMagicStudioLogicUtilshandleMagicStudioStyleOnClick", 500L)) {
                w53.b.c("WinkMagicStudioLogicUtils", "buttonInfo isFastDoubleClick");
                return;
            }
            if (!WinkMagicStudioUtils.f323888a.i(buttonInfo)) {
                String subtitleString = buttonInfo.getSubtitleString();
                if (!TextUtils.isEmpty(subtitleString)) {
                    QQToast.makeText(BaseApplication.getContext(), subtitleString, 0).show();
                    return;
                }
                return;
            }
            if (q(buttonInfo)) {
                String str3 = null;
                if (metaCategory != null) {
                    str = com.tencent.mobileqq.wink.editor.b.f(metaCategory, "protocolTitle");
                } else {
                    str = null;
                }
                if (metaCategory != null) {
                    str2 = com.tencent.mobileqq.wink.editor.b.f(metaCategory, "protocolContent");
                } else {
                    str2 = null;
                }
                if (metaCategory != null) {
                    str3 = com.tencent.mobileqq.wink.editor.b.f(metaCategory, "protocolUrl");
                }
                z(r75, str, str2, str3, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$handleMagicStudioStyleClick$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        handleActionType.invoke();
                    }
                });
                return;
            }
            handleActionType.invoke();
        }
    }

    public static /* synthetic */ void o(WinkMagicStudioLogicUtils winkMagicStudioLogicUtils, Activity activity, Fragment fragment, MagicStudioPicStyle magicStudioPicStyle, MagicStudioButtonInfo magicStudioButtonInfo, MetaCategory metaCategory, MagicStudioHistoryImageModel magicStudioHistoryImageModel, MagicStudioCreationViewModel magicStudioCreationViewModel, Function0 function0, int i3, Object obj) {
        MagicStudioHistoryImageModel magicStudioHistoryImageModel2;
        MagicStudioCreationViewModel magicStudioCreationViewModel2;
        Function0 function02;
        if ((i3 & 32) != 0) {
            magicStudioHistoryImageModel2 = null;
        } else {
            magicStudioHistoryImageModel2 = magicStudioHistoryImageModel;
        }
        if ((i3 & 64) != 0) {
            magicStudioCreationViewModel2 = null;
        } else {
            magicStudioCreationViewModel2 = magicStudioCreationViewModel;
        }
        if ((i3 & 128) != 0) {
            function02 = new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$handleMagicStudioStyleOnClick$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        } else {
            function02 = function0;
        }
        winkMagicStudioLogicUtils.n(activity, fragment, magicStudioPicStyle, magicStudioButtonInfo, metaCategory, magicStudioHistoryImageModel2, magicStudioCreationViewModel2, function02);
    }

    private final boolean q(MagicStudioButtonInfo magicStudioButtonInfo) {
        boolean z16;
        if (i()) {
            return false;
        }
        if (magicStudioButtonInfo != null && magicStudioButtonInfo.getActionType() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void s(WinkMagicStudioLogicUtils winkMagicStudioLogicUtils, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        winkMagicStudioLogicUtils.r(str, str2);
    }

    private final void t(Activity r46, Fragment fragment, MagicStudioPicStyle magicStudioPicStyle) {
        if (r46 != null && magicStudioPicStyle != null) {
            MagicStudioLogicFragment.Companion companion = MagicStudioLogicFragment.INSTANCE;
            Bundle bundle = new Bundle();
            bundle.putSerializable("magic_studio_pic_style", magicStudioPicStyle);
            Unit unit = Unit.INSTANCE;
            companion.c(r46, fragment, bundle);
        }
    }

    private final void w(c shareModel, MagicStudioPicStyle magicStudioPicStyle) {
        String replace$default;
        String replace$default2;
        String replace$default3;
        String str;
        String replace$default4;
        if (com.tencent.mobileqq.wink.editor.util.h.f322638a.g() && magicStudioPicStyle != null) {
            replace$default = StringsKt__StringsJVMKt.replace$default(shareModel.getTitle(), "${name}", magicStudioPicStyle.getName(), false, 4, (Object) null);
            shareModel.j(replace$default);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(shareModel.getDesc(), "${name}", magicStudioPicStyle.getName(), false, 4, (Object) null);
            shareModel.f(replace$default2);
            String pushImgUrl = magicStudioPicStyle.getPushImgUrl();
            if (pushImgUrl != null) {
                replace$default4 = StringsKt__StringsJVMKt.replace$default(shareModel.getPreview(), "${push_img_url}", pushImgUrl, false, 4, (Object) null);
                shareModel.g(replace$default4);
            }
            replace$default3 = StringsKt__StringsJVMKt.replace$default(shareModel.getShareUrl(), "${default_style_id}", magicStudioPicStyle.getStyleId(), false, 4, (Object) null);
            shareModel.i(replace$default3);
            String shareExternalUrl = shareModel.getShareExternalUrl();
            if (shareExternalUrl != null) {
                str = StringsKt__StringsJVMKt.replace$default(shareExternalUrl, "${default_style_id}", magicStudioPicStyle.getStyleId(), false, 4, (Object) null);
            } else {
                str = null;
            }
            shareModel.h(str);
        }
    }

    private final void z(Context context, String str, String str2, String str3, final Function0<Unit> function0) {
        if (str == null) {
            str = HardCodeUtil.qqStr(R.string.f240057o5);
        }
        String dialogPrivacyTitle = str;
        if (str2 == null) {
            str2 = HardCodeUtil.qqStr(R.string.f240047o4);
        }
        String dialogPrivacyContent = str2;
        if (TextUtils.isEmpty(str3)) {
            if (r93.h.f430993a.g()) {
                str3 = "https://rule.tencent.com/rule/202312070001";
            } else {
                str3 = "https://rule.tencent.com/rule/202312250004";
            }
        } else {
            Intrinsics.checkNotNull(str3);
        }
        Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$showPrivacyProtoDialog$dialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkMagicStudioLogicUtils.f323883a.A();
                function0.invoke();
            }
        };
        WinkMagicStudioLogicUtils$showPrivacyProtoDialog$dialog$2 winkMagicStudioLogicUtils$showPrivacyProtoDialog$dialog$2 = new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$showPrivacyProtoDialog$dialog$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        Intrinsics.checkNotNullExpressionValue(dialogPrivacyContent, "dialogPrivacyContent");
        Intrinsics.checkNotNullExpressionValue(dialogPrivacyTitle, "dialogPrivacyTitle");
        new al(context, function02, winkMagicStudioLogicUtils$showPrivacyProtoDialog$dialog$2, str3, dialogPrivacyContent, dialogPrivacyTitle).show();
    }

    public final void d(@NotNull QQPermission qqPermission, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(qqPermission, "qqPermission");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (qqPermission.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && qqPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            callback.invoke(Boolean.TRUE);
        } else {
            qqPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a(callback));
        }
    }

    public final void g(@NotNull Activity r112, @Nullable MagicStudioPicStyle magicStudioPicStyle, @NotNull Function0<Unit> shareCallback) {
        Object obj;
        Throwable th5;
        Object obj2;
        Intrinsics.checkNotNullParameter(r112, "activity");
        Intrinsics.checkNotNullParameter(shareCallback, "shareCallback");
        if (!shareIsShowing && (r112 instanceof FragmentActivity)) {
            shareIsShowing = true;
            Object cVar = new c();
            try {
                Result.Companion companion = Result.INSTANCE;
                obj = new Gson().fromJson(shareInfoJson, (Class<Object>) c.class);
                Intrinsics.checkNotNullExpressionValue(obj, "Gson().fromJson(\n       \u2026ss.java\n                )");
            } catch (Throwable th6) {
                obj = cVar;
                th5 = th6;
            }
            try {
                Result.m476constructorimpl(Unit.INSTANCE);
                obj2 = obj;
            } catch (Throwable th7) {
                th5 = th7;
                Result.Companion companion2 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th5));
                obj2 = obj;
                c cVar2 = (c) obj2;
                w(cVar2, magicStudioPicStyle);
                String j3 = j(magicStudioPicStyle);
                WinkShareManager winkShareManager = WinkShareManager.f326323a;
                winkShareManager.m((FragmentActivity) r112, cVar2, winkShareManager.h(cVar2, j3, 52130, "qzoneTemplateLibrary"), 2, new WinkMagicStudioLogicUtils$doMagicStudioActionShare$2(shareCallback), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$doMagicStudioActionShare$3
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        WinkMagicStudioLogicUtils.f323883a.y(false);
                    }
                });
            }
            c cVar22 = (c) obj2;
            w(cVar22, magicStudioPicStyle);
            String j36 = j(magicStudioPicStyle);
            WinkShareManager winkShareManager2 = WinkShareManager.f326323a;
            winkShareManager2.m((FragmentActivity) r112, cVar22, winkShareManager2.h(cVar22, j36, 52130, "qzoneTemplateLibrary"), 2, new WinkMagicStudioLogicUtils$doMagicStudioActionShare$2(shareCallback), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$doMagicStudioActionShare$3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WinkMagicStudioLogicUtils.f323883a.y(false);
                }
            });
        }
    }

    public final boolean h() {
        return needReopenAlbumFromMultiSelectFragment;
    }

    public final void k(@NotNull List<? extends LocalMediaInfo> r112, @Nullable Activity r122, boolean picMode, @Nullable MagicStudioPicStyle magicStudioPicStyle, @Nullable ArrayList<GenerateInfo> generateInfos, int regenerateCount, @Nullable Boolean publishWithOriginImage, @NotNull String styleId, @NotNull String r19) {
        Bundle bundle;
        String str;
        boolean z16;
        String tagUin;
        boolean z17;
        Intent intent;
        Intrinsics.checkNotNullParameter(r112, "localMediaInfos");
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        Intrinsics.checkNotNullParameter(r19, "materialId");
        OutputData.Companion companion = OutputData.INSTANCE;
        String str2 = null;
        if (r122 != null && (intent = r122.getIntent()) != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        OutputData b16 = companion.b(1L, r112, null, bundle);
        HashMap hashMap = new HashMap();
        hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE, WinkPublishMediaRecord.WINK_REPORT_TYPE_MAGIC_STUDIO);
        if (picMode) {
            str = "2";
        } else {
            str = "0";
        }
        hashMap.put(WinkPublishMediaRecord.QZONE_MAGIC_STUDIO_TAB, str);
        hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_STYLE_ID, styleId);
        hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_ID, r19);
        hashMap.put("xsj_again_generate", String.valueOf(regenerateCount));
        hashMap.put("xsj_generate_effect", m83.b.f416442a.c(generateInfos));
        Bundle bundle2 = b16.getBundle();
        if (bundle2 != null) {
            bundle2.putSerializable("third_party_extend_map", hashMap);
        }
        Iterator<T> it = b16.e().iterator();
        while (it.hasNext()) {
            i.s((LocalMediaInfo) it.next()).put("third_party_extend_map", hashMap);
        }
        Bundle bundle3 = b16.getBundle();
        if (bundle3 != null) {
            str2 = bundle3.getString("taguin");
        }
        boolean z18 = false;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (magicStudioPicStyle != null && (tagUin = magicStudioPicStyle.getTagUin()) != null) {
                if (tagUin.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z18 = true;
                }
            }
            if (z18) {
                Bundle bundle4 = b16.getBundle();
                if (bundle4 != null) {
                    bundle4.putString("taguin", magicStudioPicStyle.getTagUin());
                }
                Bundle bundle5 = b16.getBundle();
                if (bundle5 != null) {
                    bundle5.putString("tagtitle", magicStudioPicStyle.getTagTitle());
                }
            }
        }
        if (publishWithOriginImage != null) {
            boolean booleanValue = publishWithOriginImage.booleanValue();
            Bundle bundle6 = b16.getBundle();
            if (bundle6 != null) {
                bundle6.putBoolean(QQWinkConstants.QZONE_MAGIC_STUDIO_SHARE_ORIGIN_IMAGE, booleanValue);
            }
        }
        WinkContext.INSTANCE.d().m().k(r122, b16);
    }

    public final void m(@NotNull final Activity activity, @NotNull Fragment fragment, @NotNull MetaMaterial magicStyleMaterial, @NotNull ShadowAIGCStatus$GetStatusReply buttonInfoResp, @Nullable MetaCategory metaCategory, @Nullable MetaCategory metaCategory2, @NotNull final String imagePath, final int i3, boolean z16, @NotNull final Function2<? super List<String>, ? super Boolean, Unit> successCallback, @NotNull Function0<Unit> failedCallback, @NotNull Function0<Unit> cancelCallback, @NotNull final Function0<Unit> shareCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(magicStyleMaterial, "magicStyleMaterial");
        Intrinsics.checkNotNullParameter(buttonInfoResp, "buttonInfoResp");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failedCallback, "failedCallback");
        Intrinsics.checkNotNullParameter(cancelCallback, "cancelCallback");
        Intrinsics.checkNotNullParameter(shareCallback, "shareCallback");
        ViewModel viewModel = new ViewModelProvider(fragment).get(MagicStudioCreationViewModel.class);
        final MagicStudioCreationViewModel magicStudioCreationViewModel = (MagicStudioCreationViewModel) viewModel;
        magicStudioCreationViewModel.u3(true);
        magicStudioCreationViewModel.s3(false);
        magicStudioCreationViewModel.v3(z16);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026te = regenerate\n        }");
        x(metaCategory2);
        MagicStudioCreationViewModel.v2(magicStudioCreationViewModel, fragment, activity, null, new Function1<MagicStudioCreationViewModel.b.GotoMultiSelect, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$handleMagicStudioStyleClickDirectly$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MagicStudioCreationViewModel.b.GotoMultiSelect gotoMultiSelect) {
                invoke2(gotoMultiSelect);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MagicStudioCreationViewModel.b.GotoMultiSelect selectInfo) {
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
                ArrayList<GenerateInfo> c16 = selectInfo.getJumpInfo().c();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = c16.iterator();
                while (it.hasNext()) {
                    arrayList.add(((GenerateInfo) it.next()).getAigcImgPath());
                }
                successCallback.invoke(arrayList, Boolean.valueOf(selectInfo.getIsRegenerate()));
            }
        }, failedCallback, cancelCallback, null, false, false, 452, null);
        final MagicStudioButtonInfo a16 = MagicStudioButtonInfo.INSTANCE.a(buttonInfoResp);
        final MagicStudioPicStyle a17 = MagicStudioPicStyle.INSTANCE.a(magicStyleMaterial, metaCategory);
        l(activity, a17, a16, metaCategory, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$handleMagicStudioStyleClickDirectly$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkMagicStudioLogicUtils winkMagicStudioLogicUtils = WinkMagicStudioLogicUtils.f323883a;
                Activity activity2 = activity;
                final MagicStudioPicStyle magicStudioPicStyle = a17;
                MagicStudioButtonInfo magicStudioButtonInfo = a16;
                Function0<Unit> function0 = shareCallback;
                final MagicStudioCreationViewModel magicStudioCreationViewModel2 = magicStudioCreationViewModel;
                final String str = imagePath;
                final int i16 = i3;
                winkMagicStudioLogicUtils.e(activity2, magicStudioPicStyle, magicStudioButtonInfo, function0, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$handleMagicStudioStyleClickDirectly$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MagicStudioCreationViewModel.q3(MagicStudioCreationViewModel.this, str, magicStudioPicStyle, false, null, i16, 12, null);
                    }
                });
            }
        });
    }

    public final void n(@NotNull final Activity activity, @NotNull final Fragment fragment, @Nullable final MagicStudioPicStyle magicStudioPicStyle, @Nullable final MagicStudioButtonInfo magicStudioButtonInfo, @Nullable MetaCategory metaCategory, @Nullable final MagicStudioHistoryImageModel magicStudioHistoryImageModel, @Nullable final MagicStudioCreationViewModel magicStudioCreationViewModel, @NotNull final Function0<Unit> shareCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(shareCallback, "shareCallback");
        l(activity, magicStudioPicStyle, magicStudioButtonInfo, metaCategory, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$handleMagicStudioStyleOnClick$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkMagicStudioLogicUtils winkMagicStudioLogicUtils = WinkMagicStudioLogicUtils.f323883a;
                Activity activity2 = activity;
                MagicStudioPicStyle magicStudioPicStyle2 = magicStudioPicStyle;
                MagicStudioButtonInfo magicStudioButtonInfo2 = magicStudioButtonInfo;
                Intrinsics.checkNotNull(magicStudioButtonInfo2);
                Function0<Unit> function0 = shareCallback;
                final Activity activity3 = activity;
                final Fragment fragment2 = fragment;
                final MagicStudioPicStyle magicStudioPicStyle3 = magicStudioPicStyle;
                final MagicStudioHistoryImageModel magicStudioHistoryImageModel2 = magicStudioHistoryImageModel;
                final MagicStudioCreationViewModel magicStudioCreationViewModel2 = magicStudioCreationViewModel;
                winkMagicStudioLogicUtils.e(activity2, magicStudioPicStyle2, magicStudioButtonInfo2, function0, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils$handleMagicStudioStyleOnClick$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        WinkMagicStudioLogicUtils winkMagicStudioLogicUtils2 = WinkMagicStudioLogicUtils.f323883a;
                        Activity activity4 = activity3;
                        Fragment fragment3 = fragment2;
                        MagicStudioPicStyle magicStudioPicStyle4 = magicStudioPicStyle3;
                        Intrinsics.checkNotNull(magicStudioPicStyle4);
                        winkMagicStudioLogicUtils2.f(activity4, fragment3, magicStudioPicStyle4, magicStudioHistoryImageModel2, magicStudioCreationViewModel2);
                    }
                });
            }
        });
    }

    public final boolean p(@Nullable View btnView, @Nullable MagicStudioButtonInfo buttonInfo, @NotNull Function0<Unit> onCreateCallback, @NotNull Function0<Unit> onShareCallback) {
        Intrinsics.checkNotNullParameter(onCreateCallback, "onCreateCallback");
        Intrinsics.checkNotNullParameter(onShareCallback, "onShareCallback");
        if (btnView != null && buttonInfo != null) {
            if (FastClickUtils.isFastDoubleClick("WinkMagicStudioLogicUtilshandleRegenerateClick", 500L)) {
                w53.b.c("WinkMagicStudioLogicUtils", "buttonInfo isFastDoubleClick");
                return false;
            }
            m83.b.f416442a.q(btnView, buttonInfo);
            int actionType = buttonInfo.getActionType();
            if (actionType != 1) {
                if (actionType != 2) {
                    if (actionType != 3) {
                        if (actionType == 4) {
                            String subtitleString = buttonInfo.getSubtitleString();
                            if (!TextUtils.isEmpty(subtitleString)) {
                                QQToast.makeText(BaseApplication.getContext(), subtitleString, 0).show();
                            }
                        }
                    } else {
                        onCreateCallback.invoke();
                    }
                } else {
                    QQToast.makeText(BaseApplication.getContext(), "\u6b21\u6570\u5df2\u7ecf\u7528\u5b8c\uff0c\u5206\u4eab\u540e\u7ee7\u7eed\u4f7f\u7528", 0).show();
                    onShareCallback.invoke();
                }
            } else {
                s(this, buttonInfo.getSchemaUrl(), null, 2, null);
            }
            return true;
        }
        w53.b.c("WinkMagicStudioLogicUtils", "button view or info is null");
        return false;
    }

    public final void r(@Nullable String r46, @Nullable String src) {
        boolean z16;
        if (r46 != null) {
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse(r46));
            if (src != null && src.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                intent.putExtra("big_brother_source_key", src);
            }
            intent.addFlags(268435456);
            BaseApplication.getContext().startActivity(intent);
        }
    }

    @NotNull
    public final String u() {
        boolean z16;
        String str = null;
        try {
            str = new JSONObject(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_ai_create_re_generate", "")).getString("re_generate_title");
            w53.b.f("MultiSelectFragment", "loadRegenerateButtonConfig buttonTitle " + str + " ");
        } catch (Exception e16) {
            w53.b.d("MultiSelectFragment", "loadRegenerateButtonConfig error", e16);
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "\u91cd\u65b0\u751f\u6210";
        }
        return str;
    }

    public final void v(@Nullable Activity r26, int requestCode, int r46, @Nullable Intent data, @NotNull Function0<Unit> shareCallback) {
        Intrinsics.checkNotNullParameter(shareCallback, "shareCallback");
        if (r26 instanceof FragmentActivity) {
            Fragment findFragmentByTag = ((FragmentActivity) r26).getSupportFragmentManager().findFragmentByTag("AIGCImgSelect");
            if (findFragmentByTag instanceof MultiSelectFragment) {
                ((MultiSelectFragment) findFragmentByTag).onActivityResult(requestCode, r46, data);
            } else if (findFragmentByTag instanceof WinkMagicStudioResultFragment) {
                ((WinkMagicStudioResultFragment) findFragmentByTag).onActivityResult(requestCode, r46, data);
            } else {
                shareCallback.invoke();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(@Nullable MetaCategory metaCategory) {
        String str;
        boolean z16;
        ArrayList<MetaMaterial> arrayList;
        Object firstOrNull;
        if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            MetaMaterial metaMaterial = (MetaMaterial) firstOrNull;
            if (metaMaterial != null) {
                str = com.tencent.mobileqq.wink.editor.c.p0(metaMaterial);
                if (str == null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    shareInfoJson = str;
                    return;
                }
                return;
            }
        }
        str = null;
        if (str == null) {
        }
        z16 = true;
        if (z16) {
        }
    }

    public final void y(boolean z16) {
        shareIsShowing = z16;
    }
}
