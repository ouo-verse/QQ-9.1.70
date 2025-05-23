package com.tencent.qqnt.chathistory.ui.file.c2c.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.e;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.c;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.chathistory.ui.widget.CircleFileStateView;
import com.tencent.qqnt.chathistory.util.MsgRecordExKt;
import com.tencent.qqnt.chathistory.util.PicSize;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.util.f;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 Q2\u00020\u0001:\u0001RB'\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\b\b\u0002\u0010N\u001a\u00020\u0002\u00a2\u0006\u0004\bO\u0010PJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\u0017\u001a\u00020\u000e*\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u001e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0002R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010.\u001a\n ,*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010(R\u001c\u00102\u001a\n ,*\u0004\u0018\u00010/0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001c\u00106\u001a\n ,*\u0004\u0018\u000103038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001c\u00109\u001a\n ,*\u0004\u0018\u000107078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u00108R\u001c\u0010;\u001a\n ,*\u0004\u0018\u000107078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00108R\u001c\u0010=\u001a\n ,*\u0004\u0018\u000107078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00108R\u0014\u0010?\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00108R\u0014\u0010A\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u00108R\u001c\u0010C\u001a\n ,*\u0004\u0018\u000107078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u00108R\u001c\u0010E\u001a\n ,*\u0004\u0018\u000107078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u00108R\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010F\u00a8\u0006S"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/widget/C2CFileItemView;", "Landroid/widget/FrameLayout;", "", "chatType", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "data", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "k", "g", "j", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/c;", "param", "", "upLoad", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileTransNotifyInfo", "v", "u", "r", "needFilter", "t", "isInValid", ReportConstant.COSTREPORT_PREFIX, "l", "", WadlProxyConsts.PARAM_FILENAME, "setFileName", "source", "setSource", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "flowJob", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "e", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "ivIcon", "kotlin.jvm.PlatformType", "f", "fileStateFilter", "Lcom/tencent/qqnt/chathistory/ui/widget/CircleFileStateView;", h.F, "Lcom/tencent/qqnt/chathistory/ui/widget/CircleFileStateView;", "fileStateView", "Landroid/view/View;", "i", "Landroid/view/View;", "ivPlayIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvFileName", BdhLogUtil.LogTag.Tag_Conn, "tvFileTime", "D", "tvFileSize", "E", "tvSenderLabel", UserInfo.SEX_FEMALE, "tvSendName", "G", "tvExpireTime", "H", "tvInValid", "I", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "curData", "J", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class C2CFileItemView extends FrameLayout {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a K;

    /* renamed from: C, reason: from kotlin metadata */
    private final TextView tvFileTime;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView tvFileSize;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView tvSenderLabel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView tvSendName;

    /* renamed from: G, reason: from kotlin metadata */
    private final TextView tvExpireTime;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView tvInValid;

    /* renamed from: I, reason: from kotlin metadata */
    private FileItemModel curData;

    /* renamed from: J, reason: from kotlin metadata */
    private int source;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job flowJob;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundRectImageView ivIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final RoundRectImageView fileStateFilter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final CircleFileStateView fileStateView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final View ivPlayIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView tvFileName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/widget/C2CFileItemView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46346);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            K = new a(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public C2CFileItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
    }

    private final void g(final FileItemModel data, final CoroutineScope scope) {
        boolean z16;
        this.tvFileTime.setText(data.l());
        this.tvFileSize.setText(data.k());
        this.tvExpireTime.setText(data.p());
        if (data.A()) {
            this.tvInValid.setVisibility(0);
            this.tvExpireTime.setVisibility(8);
        } else {
            this.tvInValid.setVisibility(8);
            this.tvExpireTime.setVisibility(0);
        }
        if (data.p().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.tvExpireTime.setVisibility(8);
        }
        this.fileStateView.setProgress(data.h());
        CircleFileStateView circleFileStateView = this.fileStateView;
        circleFileStateView.setContentDescription(null);
        if (data.F()) {
            circleFileStateView.setVisibility(8);
            this.ivPlayIcon.setVisibility(0);
            t(false);
        } else if (!data.A() && !data.i()) {
            if (Intrinsics.areEqual(data.I(), e.f.f353351a)) {
                circleFileStateView.setVisibility(0);
                circleFileStateView.setState(1);
                t(true);
            } else if (Intrinsics.areEqual(data.I(), e.a.f353346a)) {
                circleFileStateView.setVisibility(0);
                circleFileStateView.setState(1);
                t(true);
            } else {
                circleFileStateView.setVisibility(0);
                if (data.B()) {
                    circleFileStateView.setState(3);
                    circleFileStateView.setContentDescription("\u4e0a\u4f20");
                } else {
                    circleFileStateView.setState(2);
                    circleFileStateView.setContentDescription("\u4e0b\u8f7d");
                }
                t(true);
            }
        } else {
            circleFileStateView.setVisibility(8);
            t(false);
        }
        this.fileStateView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2CFileItemView.h(FileItemModel.this, this, scope, view);
            }
        });
        this.ivPlayIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2CFileItemView.i(FileItemModel.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(FileItemModel data, C2CFileItemView this$0, CoroutineScope scope, View view) {
        String str;
        Map<String, Object> mutableMapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scope, "$scope");
        e I = data.I();
        d dVar = d.f354054a;
        dVar.a("C2CFileItemView", " readyClick " + I);
        if (Intrinsics.areEqual(I, e.f.f353351a)) {
            n(this$0, new c(data, PicSize.PIC_DOWNLOAD_ORI, true), false, 2, null);
            this$0.fileStateView.setState(3);
            str = String.valueOf(HistoryDtReportHelper.FileThumbContent.PAUSE.ordinal());
        } else if (Intrinsics.areEqual(I, e.a.f353346a)) {
            n(this$0, new c(data, PicSize.PIC_DOWNLOAD_ORI, false), false, 2, null);
            this$0.fileStateView.setState(2);
            str = String.valueOf(HistoryDtReportHelper.FileThumbContent.PAUSE.ordinal());
        } else if (this$0.fileStateView.a() == 2) {
            dVar.a("C2CFileItemView", " click to DownLoad " + data);
            this$0.o(new c(data, PicSize.PIC_DOWNLOAD_ORI, false, 4, null), scope);
            str = String.valueOf(HistoryDtReportHelper.FileThumbContent.DOWNLOAD.ordinal());
        } else if (this$0.fileStateView.a() == 3) {
            dVar.a("C2CFileItemView", " click to upload " + data);
            this$0.o(new c(data, PicSize.PIC_DOWNLOAD_ORI, false, 4, null), scope);
            str = String.valueOf(HistoryDtReportHelper.FileThumbContent.UPLOAD.ordinal());
        } else {
            str = "null";
        }
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        RoundRectImageView roundRectImageView = this$0.ivIcon;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("butten_content", str));
        a16.m(roundRectImageView, "em_bas_thumbnail_button", mutableMapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(FileItemModel data, C2CFileItemView this$0, View view) {
        List listOf;
        int collectionSizeOrDefault;
        Map<String, Object> mutableMapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!data.A()) {
            IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AIOMsgItem aIOMsgItem = new AIOMsgItem(data.y());
            Bundle bundle = new Bundle();
            bundle.putInt("key_source", this$0.source);
            Unit unit = Unit.INSTANCE;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(data.y());
            List list = listOf;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new AIOMsgItem((MsgRecord) it.next()));
            }
            iRichMediaBrowserApi.enterVideoPreview(peekAppRuntime, context, null, aIOMsgItem, 0L, false, false, bundle, arrayList);
            HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
            RoundRectImageView roundRectImageView = this$0.ivIcon;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("butten_content", Integer.valueOf(HistoryDtReportHelper.FileThumbContent.OTHER.ordinal())));
            a16.m(roundRectImageView, "em_bas_thumbnail_button", mutableMapOf);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j(final FileItemModel data, final CoroutineScope scope) {
        if (data.C()) {
            f.b(data.x(PicSize.PIC_DOWNLOAD_THUMB), new Function0<Unit>(data, scope) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.widget.C2CFileItemView$bindIvIcon$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ FileItemModel $data;
                final /* synthetic */ CoroutineScope $scope;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$data = data;
                    this.$scope = scope;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, C2CFileItemView.this, data, scope);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        C2CFileItemView.this.p(new c(this.$data, PicSize.PIC_DOWNLOAD_THUMB, false, 4, null), this.$scope);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, new Function1<File, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.widget.C2CFileItemView$bindIvIcon$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) C2CFileItemView.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(File file) {
                    invoke2(file);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull File it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    RoundRectImageView q16 = C2CFileItemView.this.q();
                    String absolutePath = it.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                    f.d(q16, absolutePath, 0, 0, 6, null);
                }
            });
        } else {
            Integer num = data.q().subElementType;
            if (num != null && num.intValue() == 15) {
                f.b(data.x(PicSize.PIC_DOWNLOAD_ORI), new Function0<Unit>(data, scope) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.widget.C2CFileItemView$bindIvIcon$3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ FileItemModel $data;
                    final /* synthetic */ CoroutineScope $scope;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$data = data;
                        this.$scope = scope;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, C2CFileItemView.this, data, scope);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            C2CFileItemView.this.p(new c(this.$data, PicSize.PIC_DOWNLOAD_ORI, false, 4, null), this.$scope);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                }, new Function1<File, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.widget.C2CFileItemView$bindIvIcon$4
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) C2CFileItemView.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(File file) {
                        invoke2(file);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull File it) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        RoundRectImageView q16 = C2CFileItemView.this.q();
                        String absolutePath = it.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                        f.d(q16, absolutePath, 0, 0, 6, null);
                    }
                });
            } else {
                this.ivIcon.setImageResource(data.s());
            }
        }
        s(data.A());
        this.ivPlayIcon.setVisibility(8);
    }

    private final void k(int chatType, FileItemModel data, CoroutineScope scope) {
        String string;
        TextView textView = this.tvSenderLabel;
        if (data.D()) {
            string = getContext().getString(R.string.f170738zl4);
        } else {
            string = getContext().getString(R.string.zk5);
        }
        textView.setText(string);
        MsgRecordExKt.e(this.tvSendName, chatType, data.y(), scope, 0, 8, null);
    }

    private final void m(c param, boolean upLoad) {
        if (upLoad) {
            ((IAIOFileManagerApi) QRoute.api(IAIOFileManagerApi.class)).cancelSendFile(new AIOMsgItem(param.a().y()));
        } else {
            ((IAIOFileManagerApi) QRoute.api(IAIOFileManagerApi.class)).cancelDownloadFile(new AIOMsgItem(param.a().y()));
        }
    }

    static /* synthetic */ void n(C2CFileItemView c2CFileItemView, c cVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        c2CFileItemView.m(cVar, z16);
    }

    private final void o(c param, CoroutineScope scope) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C2CFileItemView$downLoadOrUpLoad$1(param, this, null), 3, null);
        this.flowJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(c param, CoroutineScope scope) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C2CFileItemView$downLoadOrUpLoadIcon$1(param, null), 3, null);
        this.flowJob = launch$default;
    }

    private final boolean r(FileTransNotifyInfo fileTransNotifyInfo) {
        if (fileTransNotifyInfo.fileErrCode == 0) {
            return true;
        }
        return false;
    }

    private final void s(boolean isInValid) {
        float f16;
        RoundRectImageView roundRectImageView = this.ivIcon;
        if (isInValid) {
            f16 = 0.3f;
        } else {
            f16 = 1.0f;
        }
        roundRectImageView.setAlpha(f16);
    }

    private final void t(boolean needFilter) {
        int i3;
        RoundRectImageView roundRectImageView = this.fileStateFilter;
        if (needFilter) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        roundRectImageView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(FileTransNotifyInfo fileTransNotifyInfo, FileItemModel data) {
        boolean areEqual;
        int i3;
        data.H(fileTransNotifyInfo);
        data.q().filePath = fileTransNotifyInfo.filePath;
        if (r(fileTransNotifyInfo)) {
            this.fileStateView.setProgress(data.h());
            d.f354054a.a("C2CFileItemView", " updateOrigState  " + data.I());
            e I = data.I();
            if (Intrinsics.areEqual(I, e.f.f353351a)) {
                areEqual = true;
            } else {
                areEqual = Intrinsics.areEqual(I, e.a.f353346a);
            }
            if (areEqual) {
                this.fileStateView.setState(1);
                return;
            }
            if (I instanceof e.d) {
                this.fileStateView.setVisibility(8);
                this.fileStateFilter.setVisibility(8);
                this.tvExpireTime.setVisibility(8);
                return;
            } else {
                if (!(I instanceof e.b) && (I instanceof e.g)) {
                    CircleFileStateView circleFileStateView = this.fileStateView;
                    if (data.B()) {
                        i3 = 3;
                    } else {
                        i3 = 2;
                    }
                    circleFileStateView.setState(i3);
                    return;
                }
                return;
            }
        }
        d.f354054a.a("C2CFileItemView", " updateOrigState fail " + fileTransNotifyInfo.fileErrMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(FileTransNotifyInfo fileTransNotifyInfo, FileItemModel param) {
        String filePath = fileTransNotifyInfo.filePath;
        if (r(fileTransNotifyInfo) && FileUtils.fileExists(filePath)) {
            PicSize picSize = PicSize.PIC_DOWNLOAD_THUMB;
            Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
            param.G(picSize, filePath);
            f.d(this.ivIcon, filePath, 0, 0, 6, null);
            d.f354054a.a("C2CFileItemView", "updateThumpPic " + fileTransNotifyInfo);
        }
    }

    public final void l(int chatType, @NotNull FileItemModel data, @NotNull CoroutineScope scope) {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(chatType), data, scope);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.curData = data;
        j(data, scope);
        k(chatType, data, scope);
        g(data, scope);
        Job job = this.flowJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C2CFileItemView$bindView$1(this, data, null), 3, null);
        this.flowJob = launch$default;
    }

    @NotNull
    public final RoundRectImageView q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RoundRectImageView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.ivIcon;
    }

    public final void setFileName(@NotNull CharSequence fileName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fileName);
            return;
        }
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.tvFileName.setText(fileName);
        this.tvFileName.setMaxLines(1);
        this.tvFileName.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    }

    public final void setSource(int source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, source);
        } else {
            this.source = source;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public C2CFileItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ C2CFileItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public C2CFileItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.dr9, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.c_5);
        RoundRectImageView roundRectImageView = (RoundRectImageView) findViewById;
        roundRectImageView.setCornerRadiusAndMode(ViewUtils.dip2px(12.0f), 1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<RoundRectIm\u2026ImageView.MODE_ALL)\n    }");
        this.ivIcon = roundRectImageView;
        RoundRectImageView roundRectImageView2 = (RoundRectImageView) findViewById(R.id.v5f);
        roundRectImageView2.setCornerRadiusAndMode(ViewUtils.dip2px(12.0f), 1);
        roundRectImageView2.setBackgroundColor(roundRectImageView2.getResources().getColor(R.color.qui_common_overlay_dark, null));
        this.fileStateFilter = roundRectImageView2;
        this.fileStateView = (CircleFileStateView) findViewById(R.id.f163908c1);
        this.ivPlayIcon = findViewById(R.id.dws);
        this.tvFileName = (TextView) findViewById(R.id.c_g);
        this.tvFileTime = (TextView) findViewById(R.id.zfn);
        this.tvFileSize = (TextView) findViewById(R.id.c_j);
        View findViewById2 = findViewById(R.id.f83224iz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R.id.sender_label)");
        this.tvSenderLabel = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f83044ii);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R.id.sendName)");
        this.tvSendName = (TextView) findViewById3;
        this.tvExpireTime = (TextView) findViewById(R.id.f107836bh);
        this.tvInValid = (TextView) findViewById(R.id.f1052265f);
    }
}
