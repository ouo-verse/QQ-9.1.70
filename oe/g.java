package oe;

import android.content.DialogInterface;
import com.qzone.common.account.LoginData;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDeleteManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteFeedRsp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\rH\u0016R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Loe/g;", "Lcom/qzone/reborn/share/a;", "Lre/b;", "y", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "Lcom/qzone/reborn/share/e;", "shareContext", "", "w", "feed", "B", HippyTKDListViewAdapter.X, "", "j", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, NodeProps.VISIBLE, "k", "c", "Z", "isDelMediaFileInAlbum", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends com.qzone.reborn.share.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isDelMediaFileInAlbum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"oe/g$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/DeleteFeedRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements DataCallback<DeleteFeedRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.share.e f422526b;

        b(com.qzone.reborn.share.e eVar) {
            this.f422526b = eVar;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(DeleteFeedRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QQToastUtil.showQQToastInUiThread(5, "\u5220\u9664\u6210\u529f");
            re.b y16 = g.this.y();
            boolean z16 = false;
            if (y16 != null && y16.getIsFromDetail()) {
                z16 = true;
            }
            if (z16) {
                this.f422526b.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().finish();
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            boolean z16 = true;
            QLog.e("QzoneFeedProDetailShareDeleteAction", 1, "deleteFeed errorcode:" + errorCode + ", errorMsg:" + errorMsg);
            if (errorMsg != null && errorMsg.length() != 0) {
                z16 = false;
            }
            if (z16) {
                errorMsg = "\u5220\u9664\u5931\u8d25";
            }
            QQToastUtil.showQQToastInUiThread(4, errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(g this$0, CommonFeed commonFeed, com.qzone.reborn.share.e shareContext, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        if (!NetworkState.isNetSupport()) {
            c6.a.h(R.string.ghi);
        } else {
            this$0.x(commonFeed, shareContext);
        }
    }

    private final void B(final CommonFeed feed, final com.qzone.reborn.share.e shareContext) {
        this.isDelMediaFileInAlbum = QZoneFeedUtil.z();
        QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 230, null, HardCodeUtil.qqStr(R.string.gey), com.qzone.reborn.feedpro.utils.m.a(feed), this.isDelMediaFileInAlbum, HardCodeUtil.qqStr(R.string.gd5), HardCodeUtil.qqStr(R.string.a8j), new DialogInterface.OnClickListener() { // from class: oe.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                g.C(g.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: oe.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                g.D(g.this, feed, shareContext, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: oe.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                g.E(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createDialogWithCheckBox, "createDialogWithCheckBox\u2026    { dialog, which -> })");
        createDialogWithCheckBox.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(g this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isDelMediaFileInAlbum = i3 == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(g this$0, CommonFeed commonFeed, com.qzone.reborn.share.e shareContext, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        if (!NetworkState.isNetSupport()) {
            c6.a.h(R.string.ghi);
        } else {
            this$0.x(commonFeed, shareContext);
            u5.b.p0("key_last_checked_state_del_media_file", this$0.isDelMediaFileInAlbum, LoginData.getInstance().getUin());
        }
    }

    private final void w(CommonFeed commonFeed, com.qzone.reborn.share.e shareContext) {
        List<Integer> arrayList;
        if (this.isDelMediaFileInAlbum) {
            arrayList = CollectionsKt__CollectionsKt.mutableListOf(1);
        } else {
            arrayList = new ArrayList<>();
        }
        new QzoneFeedDeleteManager().deleteFeed(commonFeed, arrayList, new b(shareContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final re.b y() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.b) {
            return (re.b) viewModel;
        }
        return null;
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProDetailShareDeleteAction", 2, "share clicked");
        re.b y16 = y();
        if ((y16 != null ? y16.S1() : null) == null) {
            QLog.e("QzoneFeedProDetailShareDeleteAction", 1, "commonFeed is null");
        } else {
            re.b y17 = y();
            z(y17 != null ? y17.S1() : null, shareContext);
        }
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("delete");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        re.b y16 = y();
        if (!(y16 != null ? y16.U1() : false)) {
            return false;
        }
        ao aoVar = ao.f54312a;
        re.b y17 = y();
        return aoVar.d(y17 != null ? y17.S1() : null, 4);
    }

    @Override // com.qzone.reborn.share.a
    public void k(com.qzone.reborn.share.e shareContext, boolean visible) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (visible) {
            return;
        }
        this.isDelMediaFileInAlbum = false;
    }

    public final void z(final CommonFeed feed, final com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (!NetworkUtil.isNetSupport(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String())) {
            c6.a.j(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 3);
            return;
        }
        if ((feed != null ? feed.getCellCommon() : null) == null) {
            return;
        }
        if (com.qzone.reborn.feedpro.utils.m.f(feed)) {
            B(feed, shareContext);
        } else {
            new com.qzone.component.e().g(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), null, com.qzone.reborn.feedpro.utils.m.b(feed), new DialogInterface.OnClickListener() { // from class: oe.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.A(g.this, feed, shareContext, dialogInterface, i3);
                }
            }, null);
        }
    }

    private final void x(CommonFeed feed, com.qzone.reborn.share.e shareContext) {
        CommonCellCommon cellCommon;
        if (((feed == null || (cellCommon = feed.getCellCommon()) == null) ? null : cellCommon.getUnionId()) != null) {
            Intrinsics.checkNotNull(feed);
            w(feed, shareContext);
        } else {
            QLog.e("QzoneFeedProDetailShareDeleteAction", 1, "unionId is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(DialogInterface dialogInterface, int i3) {
    }
}
