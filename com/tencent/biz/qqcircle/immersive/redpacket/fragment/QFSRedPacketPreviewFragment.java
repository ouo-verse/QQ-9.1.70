package com.tencent.biz.qqcircle.immersive.redpacket.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.redpacket.part.QFSRedPacketPreviewInfoPart;
import com.tencent.biz.qqcircle.immersive.redpacket.part.QFSRedPacketPreviewPlayPart;
import com.tencent.biz.qqcircle.immersive.redpacket.part.aa;
import com.tencent.biz.qqcircle.immersive.redpacket.part.ap;
import com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R#\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/fragment/QFSRedPacketPreviewFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "getPageId", "getDaTongPageId", "", "registerDaTongReportPageId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "Landroid/content/Intent;", "newIntent", "onNewIntent", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/h;", "kotlin.jvm.PlatformType", "E", "Lkotlin/Lazy;", "sh", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/h;", "viewModel", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketPreviewPlayPart;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketPreviewPlayPart;", "playPart", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketPreviewInfoPart;", "G", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketPreviewInfoPart;", "infoPart", "<init>", "()V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRedPacketPreviewFragment extends QFSBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QFSRedPacketPreviewPlayPart playPart;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QFSRedPacketPreviewInfoPart infoPart;

    public QFSRedPacketPreviewFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.fragment.QFSRedPacketPreviewFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return (h) QFSRedPacketPreviewFragment.this.getViewModel(h.class);
            }
        });
        this.viewModel = lazy;
    }

    private final h sh() {
        return (h) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map th(QFSRedPacketPreviewFragment this$0, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, Object> it = new QCircleDTParamBuilder().buildDynamicParams().getDynamicParams(str);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        QFSRedPacketPreviewInfoPart qFSRedPacketPreviewInfoPart = this$0.infoPart;
        boolean z16 = false;
        if (qFSRedPacketPreviewInfoPart != null && qFSRedPacketPreviewInfoPart.ia()) {
            z16 = true;
        }
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        it.put(QCircleDaTongConstant.ElementParamKey.QQ_IS_RED_ENVELOPE_OPEN, str2);
        return it;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        QFSRedPacketPreviewPlayPart qFSRedPacketPreviewPlayPart = new QFSRedPacketPreviewPlayPart();
        this.playPart = qFSRedPacketPreviewPlayPart;
        Unit unit = Unit.INSTANCE;
        QFSRedPacketPreviewInfoPart qFSRedPacketPreviewInfoPart = new QFSRedPacketPreviewInfoPart();
        this.infoPart = qFSRedPacketPreviewInfoPart;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ap(R.drawable.nuh, R.color.cmc, R.string.f194754cr), qFSRedPacketPreviewPlayPart, qFSRedPacketPreviewInfoPart, new aa());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gq8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_QQ_PREVIEW_RED_ENVELOPE_COVER_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSRedPacketPreviewFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent newIntent) {
        super.onNewIntent(newIntent);
        QLog.d("QFSRedPacketPreviewFragment", 1, "onNewIntent ");
        sh().S1(newIntent);
        QFSRedPacketPreviewPlayPart qFSRedPacketPreviewPlayPart = this.playPart;
        if (qFSRedPacketPreviewPlayPart != null) {
            qFSRedPacketPreviewPlayPart.D9();
        }
        QFSRedPacketPreviewInfoPart qFSRedPacketPreviewInfoPart = this.infoPart;
        if (qFSRedPacketPreviewInfoPart != null) {
            qFSRedPacketPreviewInfoPart.ra();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        Intent intent;
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        QLog.d("QFSRedPacketPreviewFragment", 1, "onViewCreatedBeforePartInit ");
        h sh5 = sh();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        sh5.S1(intent);
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
        super.registerDaTongReportPageId();
        VideoReport.setEventDynamicParams(((QCircleBaseFragment) this).mContentView, new IDynamicParams() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.fragment.b
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map th5;
                th5 = QFSRedPacketPreviewFragment.th(QFSRedPacketPreviewFragment.this, str);
                return th5;
            }
        });
    }
}
