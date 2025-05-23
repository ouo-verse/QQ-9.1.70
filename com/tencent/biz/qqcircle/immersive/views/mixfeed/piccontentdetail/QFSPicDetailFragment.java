package com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragmentFix;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSlideRightActionEvent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil;
import com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p40.u;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0015J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0016J(\u0010\u0014\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00110\u0010j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011`\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/QFSPicDetailFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragmentFix;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onResume", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "", "getLogTag", "getDaTongPageId", "getPageId", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "rh", "", "isUseDarkTextStatusBar", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "E", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "mInitBean", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPicDetailFragment extends QFSBaseFragmentFix {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    private QCircleInitBean mInitBean;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/QFSPicDetailFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "bean", "", "a", "", "DT_PAGE_ID", "Ljava/lang/String;", "", "PAGE_ID", "I", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail.QFSPicDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull QCircleInitBean bean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intent intent = new Intent();
            intent.putExtra("public_fragment_class", QFSPicDetailFragment.class.getName());
            intent.putExtra("key_bundle_common_init_bean", bean);
            intent.addFlags(268435456);
            intent.setClass(context, QCircleFragmentActivity.class);
            QCircleLauncherUtil.o(context, intent);
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final void sh(@NotNull Context context, @NotNull QCircleInitBean qCircleInitBean) {
        INSTANCE.a(context, qCircleInitBean);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[2];
        PartManager partManager = getPartManager();
        Intrinsics.checkNotNullExpressionValue(partManager, "partManager");
        QCircleInitBean qCircleInitBean = this.mInitBean;
        QCircleInitBean qCircleInitBean2 = null;
        if (qCircleInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean = null;
        }
        partArr[0] = new d(partManager, qCircleInitBean);
        QCircleInitBean qCircleInitBean3 = this.mInitBean;
        if (qCircleInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
        } else {
            qCircleInitBean2 = qCircleInitBean3;
        }
        partArr[1] = new o50.a(qCircleInitBean2);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @Deprecated(message = "Deprecated in Java")
    public int getContentLayoutId() {
        return R.layout.gfz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_PICTEXT_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPicContentDetailFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 19999;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        u.H().E0();
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getActivity());
        Intrinsics.checkNotNull(qCircleInitBean, "null cannot be cast to non-null type com.tencent.biz.qqcircle.beans.QCircleInitBean");
        this.mInitBean = qCircleInitBean;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QCircleInitBean qCircleInitBean = this.mInitBean;
        if (qCircleInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            qCircleInitBean = null;
        }
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs != null) {
            com.tencent.biz.qqcircle.launcher.d.a(schemeAttrs);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Activity activity;
        super.onResume();
        Context hostContext = ASEngineUtils.getHostContext(getActivity());
        if (hostContext instanceof Activity) {
            activity = (Activity) hostContext;
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        RFWThemeUtil.setStatusBarColor(activity, 0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragmentFix
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> rh() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSLazyExecuteEvent.class, QFSEnableSlideRightActionEvent.class, QFSSlideRightActionEvent.class);
        return arrayListOf;
    }
}
