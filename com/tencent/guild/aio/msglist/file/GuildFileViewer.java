package com.tencent.guild.aio.msglist.file;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.msglist.file.GuildFileViewer;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.guild.aio.util.ui.GuildChatPicDownloader;
import com.tencent.guild.aio.util.ui.PicSize;
import com.tencent.guild.aio.util.ui.RoundBubbleImageView;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.aio.util.x;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.b;
import com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ;2\u00020\u0001:\u000259B\u008a\u0001\u0012\u0006\u0010\f\u001a\u00020U\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010B\u001a\u0004\u0018\u00010=\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012M\u0010R\u001aI\u0012\u0013\u0012\u00110G\u00a2\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110-\u00a2\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\u00020F\u00a2\u0006\u0004\bb\u0010cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J \u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010#\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u0002H\u0002J\b\u0010&\u001a\u00020\u0002H\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010*\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010+\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010,\u001a\u00020\u000fH\u0002J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-H\u0002J\u000e\u00100\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u00101\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u00104\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u0001R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0019\u0010B\u001a\u0004\u0018\u00010=8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\b\u0010\u0010ER^\u0010R\u001aI\u0012\u0013\u0012\u00110G\u00a2\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110-\u00a2\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\u00020F8\u0006\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010SR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010VR\u0016\u0010Y\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010XR\u001b\u0010^\u001a\u00020Z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b[\u0010]R\u001b\u0010a\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010\\\u001a\u0004\b_\u0010`\u00a8\u0006d"}, d2 = {"Lcom/tencent/guild/aio/msglist/file/GuildFileViewer;", "", "", h.F, "Landroid/view/ViewGroup;", "contentView", "u", "Landroid/content/Context;", "context", "Lcom/tencent/guild/aio/util/ui/RoundBubbleImageView;", "g", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "", "isMultiSelect", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "E", "", "transferStatus", ReportConstant.COSTREPORT_PREFIX, "opType", "B", "entity", "trasferStatus", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "isMultiSelectMode", "p", "y", "f", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "t", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/guild/api/data/msglist/b$f;", "sendStatus", "o", "r", "w", "Landroid/view/View;", "v", DomainData.DOMAIN_NAME, "G", UserInfo.SEX_FEMALE, "msg", "payload", "D", "a", "Landroid/view/ViewGroup;", "j", "()Landroid/view/ViewGroup;", "b", "Landroid/content/Context;", "k", "()Landroid/content/Context;", "Lcom/tencent/aio/api/runtime/a;", "c", "Lcom/tencent/aio/api/runtime/a;", "getAioContext", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "d", "Z", "()Z", "Lkotlin/Function3;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/ParameterName;", "name", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "clickedView", "e", "Lkotlin/jvm/functions/Function3;", "getListener", "()Lkotlin/jvm/functions/Function3;", "listener", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Ljava/lang/String;", "tvDescText", "Lcom/tencent/guild/aio/msglist/file/GuildFileViewer$a;", "i", "Lkotlin/Lazy;", "()Lcom/tencent/guild/aio/msglist/file/GuildFileViewer$a;", "binding", "l", "()Lcom/tencent/guild/aio/util/ui/RoundBubbleImageView;", "picFileView", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;Landroid/view/ViewGroup;Landroid/content/Context;Lcom/tencent/aio/api/runtime/a;ZLkotlin/jvm/functions/Function3;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildFileViewer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup contentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isMultiSelect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<MsgRecord, PicElement, View, Unit> listener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgElement element;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildMsgItem currentMsgItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String tvDescText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy picFileView;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010 \u001a\u0004\b\u0003\u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020%8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010&\u001a\u0004\b\u0015\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/guild/aio/msglist/file/GuildFileViewer$a;", "", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "e", "()Landroid/view/ViewGroup;", "l", "(Landroid/view/ViewGroup;)V", "root", "Landroid/widget/RelativeLayout;", "b", "Landroid/widget/RelativeLayout;", "()Landroid/widget/RelativeLayout;", "i", "(Landroid/widget/RelativeLayout;)V", "msgFile", "c", "j", "msgVideo", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "g", "()Landroid/widget/TextView;", DomainData.DOMAIN_NAME, "(Landroid/widget/TextView;)V", "tvTitle", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tvDesc", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", h.F, "(Landroid/widget/ImageView;)V", "ivFileIcon", "Landroid/widget/ProgressBar;", "Landroid/widget/ProgressBar;", "()Landroid/widget/ProgressBar;", "k", "(Landroid/widget/ProgressBar;)V", "pbLoading", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public ViewGroup root;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public RelativeLayout msgFile;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public RelativeLayout msgVideo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public TextView tvTitle;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public TextView tvDesc;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public ImageView ivFileIcon;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public ProgressBar pbLoading;

        @NotNull
        public final ImageView a() {
            ImageView imageView = this.ivFileIcon;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("ivFileIcon");
            return null;
        }

        @NotNull
        public final RelativeLayout b() {
            RelativeLayout relativeLayout = this.msgFile;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("msgFile");
            return null;
        }

        @NotNull
        public final RelativeLayout c() {
            RelativeLayout relativeLayout = this.msgVideo;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("msgVideo");
            return null;
        }

        @NotNull
        public final ProgressBar d() {
            ProgressBar progressBar = this.pbLoading;
            if (progressBar != null) {
                return progressBar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pbLoading");
            return null;
        }

        @NotNull
        public final ViewGroup e() {
            ViewGroup viewGroup = this.root;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("root");
            return null;
        }

        @NotNull
        public final TextView f() {
            TextView textView = this.tvDesc;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
            return null;
        }

        @NotNull
        public final TextView g() {
            TextView textView = this.tvTitle;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            return null;
        }

        public final void h(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.ivFileIcon = imageView;
        }

        public final void i(@NotNull RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.msgFile = relativeLayout;
        }

        public final void j(@NotNull RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.msgVideo = relativeLayout;
        }

        public final void k(@NotNull ProgressBar progressBar) {
            Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
            this.pbLoading = progressBar;
        }

        public final void l(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.root = viewGroup;
        }

        public final void m(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvDesc = textView;
        }

        public final void n(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTitle = textView;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildFileViewer(@NotNull GuildMsgItem msgItem, @Nullable MsgElement msgElement, @NotNull ViewGroup contentView, @NotNull Context context, @Nullable com.tencent.aio.api.runtime.a aVar, boolean z16, @NotNull Function3<? super MsgRecord, ? super PicElement, ? super View, Unit> listener) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.contentView = contentView;
        this.context = context;
        this.aioContext = aVar;
        this.isMultiSelect = z16;
        this.listener = listener;
        this.element = msgElement;
        this.currentMsgItem = msgItem;
        this.tvDescText = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.guild.aio.msglist.file.GuildFileViewer$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFileViewer.a invoke() {
                GuildFileViewer.a aVar2 = new GuildFileViewer.a();
                a aVar3 = new a(GuildFileViewer.this.getContentView().getContext());
                ViewGroup b16 = aVar3.b();
                Intrinsics.checkNotNullExpressionValue(b16, "view.root");
                aVar2.l(b16);
                RelativeLayout relativeLayout = aVar3.f111273c;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "view.msgFile");
                aVar2.i(relativeLayout);
                RelativeLayout relativeLayout2 = aVar3.f111278h;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "view.msgVideo");
                aVar2.j(relativeLayout2);
                TextView textView = aVar3.f111274d;
                Intrinsics.checkNotNullExpressionValue(textView, "view.tvTitle");
                aVar2.n(textView);
                ImageView imageView = aVar3.f111275e;
                Intrinsics.checkNotNullExpressionValue(imageView, "view.ivFileIcon");
                aVar2.h(imageView);
                TextView textView2 = aVar3.f111276f;
                Intrinsics.checkNotNullExpressionValue(textView2, "view.tvDesc");
                aVar2.m(textView2);
                ProgressBar progressBar = aVar3.f111277g;
                Intrinsics.checkNotNullExpressionValue(progressBar, "view.pbLoading");
                aVar2.k(progressBar);
                return aVar2;
            }
        });
        this.binding = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RoundBubbleImageView>() { // from class: com.tencent.guild.aio.msglist.file.GuildFileViewer$picFileView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundBubbleImageView invoke() {
                RoundBubbleImageView g16;
                GuildFileViewer guildFileViewer = GuildFileViewer.this;
                g16 = guildFileViewer.g(guildFileViewer.getContext());
                return g16;
            }
        });
        this.picFileView = lazy2;
        h();
    }

    private final String A(FileElement entity, int trasferStatus) {
        Integer num = entity.invalidState;
        if (num == null || num.intValue() != 0) {
            String string = this.contentView.getContext().getString(R.string.f139150ah);
            Intrinsics.checkNotNullExpressionValue(string, "contentView.context.getS\u2026g.guild_aio_file_invalid)");
            return string;
        }
        if (trasferStatus == 5) {
            if (this.currentMsgItem.isLocalSend()) {
                String string2 = this.contentView.getContext().getString(R.string.f139140ag);
                Intrinsics.checkNotNullExpressionValue(string2, "{\n                conten\u2026_file_fail)\n            }");
                return string2;
            }
            String string3 = this.contentView.getContext().getString(R.string.f139130af);
            Intrinsics.checkNotNullExpressionValue(string3, "{\n                conten\u2026nload_fail)\n            }");
            return string3;
        }
        if (trasferStatus == 6) {
            String string4 = this.contentView.getContext().getString(R.string.f139110ad);
            Intrinsics.checkNotNullExpressionValue(string4, "contentView.context.getS\u2026ng.guild_aio_file_cancel)");
            return string4;
        }
        if (trasferStatus == 4) {
            if (this.currentMsgItem.isLocalSend()) {
                String string5 = this.contentView.getContext().getString(R.string.f139170aj);
                Intrinsics.checkNotNullExpressionValue(string5, "contentView.context.getS\u2026ring.guild_aio_file_send)");
                return string5;
            }
            String string6 = this.contentView.getContext().getString(R.string.f139120ae);
            Intrinsics.checkNotNullExpressionValue(string6, "contentView.context.getS\u2026.guild_aio_file_download)");
            return string6;
        }
        if ((trasferStatus == 0 || trasferStatus == 1 || trasferStatus == 3) && !this.currentMsgItem.isLocalSend()) {
            if (vp0.b.e(entity)) {
                String string7 = this.contentView.getContext().getString(R.string.f139160ai);
                Intrinsics.checkNotNullExpressionValue(string7, "{\n                conten\u2026e_overtime)\n            }");
                return string7;
            }
            Long l3 = entity.expireTime;
            Intrinsics.checkNotNullExpressionValue(l3, "entity.expireTime");
            return " / " + vp0.b.a(l3.longValue());
        }
        return "";
    }

    private final int B(int opType) {
        if (opType != 0) {
            if (opType != 2) {
                if (opType != 3) {
                    if (opType != 4) {
                        if (opType != 5) {
                            return -1;
                        }
                        return 0;
                    }
                    return R.drawable.guild_file_download_fail;
                }
                return R.drawable.guild_file_download_pause;
            }
            return R.drawable.guild_file_download_btn;
        }
        return R.drawable.gxn;
    }

    private final void C(FileTransNotifyInfo fileInfo) {
        MsgElement msgElement = this.element;
        if (msgElement != null) {
            i().d().setProgress(x.f112474a.c(msgElement, 3, fileInfo));
            i().d().setVisibility(0);
        }
    }

    private final void E(FileElement fileElement, FileTransNotifyInfo fileInfo) {
        Integer transferStatus;
        if (fileInfo != null) {
            transferStatus = Integer.valueOf(fileInfo.trasferStatus);
        } else {
            transferStatus = fileElement.transferStatus;
        }
        Intrinsics.checkNotNullExpressionValue(transferStatus, "transferStatus");
        String A = A(fileElement, transferStatus.intValue());
        i().f().setText(this.tvDescText + A);
        int B = B(s(transferStatus.intValue()));
        if (B > 0) {
            Drawable drawable = this.contentView.getContext().getResources().getDrawable(B);
            Intrinsics.checkNotNullExpressionValue(drawable, "contentView.context.resources.getDrawable(iconID)");
            drawable.setBounds(0, 0, this.contentView.getContext().getResources().getDimensionPixelSize(R.dimen.f158711n0), this.contentView.getContext().getResources().getDimensionPixelSize(R.dimen.f158711n0));
            i().f().setCompoundDrawables(null, null, drawable, null);
            return;
        }
        i().f().setCompoundDrawables(null, null, null, null);
    }

    private final void f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ImageView imageView = new ImageView(this.contentView.getContext());
        imageView.setImageResource(R.drawable.oc5);
        layoutParams.addRule(13);
        i().c().addView(imageView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoundBubbleImageView g(Context context) {
        RoundBubbleImageView roundBubbleImageView = new RoundBubbleImageView(context);
        roundBubbleImageView.setRadiusDP(6.0f);
        return roundBubbleImageView;
    }

    private final void h() {
        FileElement fileElement;
        if (this.contentView.getChildCount() > 0) {
            this.contentView.removeAllViews();
        }
        MsgElement msgElement = this.element;
        if (msgElement != null && (fileElement = msgElement.fileElement) != null) {
            String str = fileElement.fileName;
            Intrinsics.checkNotNullExpressionValue(str, "it.fileName");
            int d16 = vp0.b.d(str);
            if (d16 != 0) {
                if (d16 != 2) {
                    m(this.currentMsgItem, fileElement, this.isMultiSelect);
                    u(this.contentView);
                    return;
                }
                MsgElement msgElement2 = this.element;
                Intrinsics.checkNotNull(msgElement2);
                p(msgElement2, fileElement, this.isMultiSelect);
                u(this.contentView);
                f();
                return;
            }
            MsgElement msgElement3 = this.element;
            Intrinsics.checkNotNull(msgElement3);
            p(msgElement3, fileElement, this.isMultiSelect);
            u(this.contentView);
        }
    }

    private final a i() {
        return (a) this.binding.getValue();
    }

    private final RoundBubbleImageView l() {
        return (RoundBubbleImageView) this.picFileView.getValue();
    }

    private final void m(com.tencent.aio.data.msglist.a msgItem, FileElement fileElement, boolean isMultiSelect) {
        a i3 = i();
        i3.b().setVisibility(0);
        i3.c().setVisibility(8);
        int i16 = i().g().getContext().getResources().getDisplayMetrics().densityDpi;
        i().g().setText(fileElement.fileName);
        String a16 = vp0.a.a(fileElement.fileSize, i16);
        Intrinsics.checkNotNullExpressionValue(a16, "formatFileSizeNotSync(fileElement.fileSize, dpi)");
        this.tvDescText = a16;
        ImageView a17 = i().a();
        String str = fileElement.fileName;
        Intrinsics.checkNotNullExpressionValue(str, "fileElement.fileName");
        a17.setImageResource(vp0.b.c(vp0.b.d(str)));
        x(isMultiSelect);
        E(fileElement, null);
    }

    private final void n(View v3) {
        FileElement fileElement;
        if (fo0.b.c(this.aioContext)) {
            QLog.i("GuildFileViewer", 1, "interceptOperationWhenInGuestInputMode");
            return;
        }
        MsgElement msgElement = this.element;
        if (msgElement != null && (fileElement = msgElement.fileElement) != null) {
            if (vp0.b.e(fileElement) && !FileUtils.fileExistsAndNotEmpty(fileElement.filePath)) {
                String string = this.context.getString(R.string.f145830sj);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.guild_file_overtime)");
                QQToast.makeText(this.context, 1, string, 1).show();
                return;
            } else {
                Integer num = fileElement.invalidState;
                if (num == null || num.intValue() != 0) {
                    String string2 = this.context.getString(R.string.f145820si);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.guild_file_invalid)");
                    QQToast.makeText(this.context, 1, string2, 1).show();
                    return;
                }
            }
        }
        AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
        IGuildRichMediaBrowserApi iGuildRichMediaBrowserApi = (IGuildRichMediaBrowserApi) QRoute.api(IGuildRichMediaBrowserApi.class);
        Intrinsics.checkNotNullExpressionValue(app, "app");
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        iGuildRichMediaBrowserApi.enterFileBrowser(app, context, this.currentMsgItem.getMsgRecord());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(b.GuildMsgItemStatusPayload sendStatus) {
        if (sendStatus != null && sendStatus.getSendStatus() == 0) {
            z();
        }
    }

    private final void p(MsgElement msgElement, FileElement fileElement, boolean isMultiSelectMode) {
        if (i().c().getChildCount() > 0) {
            i().c().removeAllViews();
        }
        if (y(msgElement, fileElement)) {
            UIUtil.f112434a.b(msgElement, this.currentMsgItem, l(), false, isMultiSelectMode, this.listener);
        } else {
            RelativeLayout.LayoutParams h16 = UIUtil.f112434a.h(msgElement, false, isMultiSelectMode);
            l().setImageDrawable(UIUtil.u(h16.width, h16.height));
            l().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.file.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildFileViewer.q(GuildFileViewer.this, view);
                }
            });
        }
        View findViewById = this.contentView.findViewById(R.id.f164907u83);
        if (findViewById != null) {
            findViewById.setBackground(null);
            findViewById.setPadding(0, 0, 0, 0);
        }
        a i3 = i();
        i3.b().setVisibility(8);
        i3.c().setVisibility(0);
        l().setId(R.id.wfr);
        i3.c().addView(l());
        l().setContentDescription(this.context.getString(R.string.f1385709x) + fileElement.fileName);
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        relativeLayout.setId(R.id.v55);
        relativeLayout.setBackgroundResource(R.drawable.guild_aio_filepic_bottombar_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.guild.aio.util.c.b(55));
        layoutParams.addRule(8, R.id.wfr);
        layoutParams.addRule(5, R.id.wfr);
        layoutParams.addRule(7, R.id.wfr);
        i().c().addView(relativeLayout, layoutParams);
        TextView textView = new TextView(this.context);
        textView.setId(R.id.wfq);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l().getLayoutParams().width - com.tencent.guild.aio.util.c.b(10), -2);
        layoutParams2.leftMargin = com.tencent.guild.aio.util.c.b(7);
        layoutParams2.rightMargin = com.tencent.guild.aio.util.c.b(7);
        layoutParams2.bottomMargin = com.tencent.guild.aio.util.c.b(7);
        layoutParams2.addRule(12);
        i().c().addView(textView, layoutParams2);
        TextView textView2 = new TextView(this.context, null);
        textView2.setId(R.id.wfs);
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(-1);
        textView2.setSingleLine();
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(l().getLayoutParams().width - com.tencent.guild.aio.util.c.b(10), -2);
        layoutParams3.leftMargin = com.tencent.guild.aio.util.c.b(7);
        layoutParams3.rightMargin = com.tencent.guild.aio.util.c.b(7);
        layoutParams3.bottomMargin = com.tencent.guild.aio.util.c.b(7);
        int j3 = UIUtil.f112434a.j(l().getLayoutParams().width, l().getLayoutParams().height);
        if (j3 == 1) {
            layoutParams3.addRule(12);
            layoutParams3.addRule(2, R.id.wfq);
        } else {
            layoutParams3.addRule(12);
        }
        i().c().addView(textView2, layoutParams3);
        if (j3 != 1) {
            if (j3 == 2) {
                textView2.setLines(1);
                textView2.setMaxLines(1);
                ViewExtKt.c(textView2, com.tencent.guild.aio.util.c.b(7));
                textView.setGravity(5);
                ViewExtKt.e(textView, com.tencent.guild.aio.util.c.b(7));
                ViewExtKt.c(textView, com.tencent.guild.aio.util.c.b(7));
            }
        } else {
            textView2.setLines(2);
            textView2.setMaxLines(2);
            ViewExtKt.c(textView2, com.tencent.guild.aio.util.c.b(7));
            textView.setGravity(3);
            ViewExtKt.c(textView, com.tencent.guild.aio.util.c.b(7));
        }
        textView2.setText(fileElement.fileName);
        textView.setText(vp0.a.a(fileElement.fileSize, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GuildFileViewer this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.context;
        QQToast.makeText(context, 1, context.getString(R.string.f145830sj), 1).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(FileTransNotifyInfo fileInfo) {
        if (fileInfo != null) {
            int i3 = fileInfo.trasferStatus;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 == 6) {
                                t();
                                G(fileInfo);
                                return;
                            }
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("GuildFileViewer", 2, "download fail, msgId = " + fileInfo.msgId + ", elementID = " + fileInfo.msgElementId + ", downloadType = " + fileInfo.fileDownType);
                        }
                        if (w() || fileInfo.fileDownType != 2) {
                            z();
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("GuildFileViewer", 2, "download success, msgId = " + fileInfo.msgId + ", elementID = " + fileInfo.msgElementId + ", downloadType = " + fileInfo.fileDownType);
                    }
                    if (fileInfo.fileDownType == 1) {
                        t();
                    }
                    G(fileInfo);
                    return;
                }
                if (fileInfo.fileDownType != 2) {
                    C(fileInfo);
                    G(fileInfo);
                    return;
                }
                return;
            }
            if (fileInfo.fileDownType != 2) {
                C(fileInfo);
            }
        }
    }

    private final int s(int transferStatus) {
        if (transferStatus != 0 && transferStatus != 1) {
            int i3 = 3;
            if (transferStatus != 3) {
                i3 = 5;
                if (transferStatus != 4) {
                    if (transferStatus == 5 || transferStatus == 6) {
                        return 4;
                    }
                    return 0;
                }
            }
            return i3;
        }
        return 2;
    }

    private final void t() {
        i().d().setVisibility(8);
    }

    private final void u(ViewGroup contentView) {
        View e16 = i().e();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        e16.setLayoutParams(layoutParams);
        contentView.addView(e16);
        i().b().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.file.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildFileViewer.v(GuildFileViewer.this, view);
            }
        });
        VideoReport.setElementId(i().b(), "em_click_file");
        VideoReport.setElementClickPolicy(i().b(), ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(GuildFileViewer this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.n(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final boolean w() {
        FileElement fileElement;
        MsgElement msgElement = this.element;
        if (msgElement == null || (fileElement = msgElement.fileElement) == null) {
            return false;
        }
        String str = fileElement.fileName;
        Intrinsics.checkNotNullExpressionValue(str, "it.fileName");
        if (vp0.b.d(str) != 0) {
            return false;
        }
        return true;
    }

    private final void x(boolean isMultiSelect) {
        RelativeLayout b16 = i().b();
        if (isMultiSelect) {
            UIUtil uIUtil = UIUtil.f112434a;
            b16.setLayoutParams(new RelativeLayout.LayoutParams((int) (((uIUtil.l() - uIUtil.w()) - uIUtil.n()) + 0.5f), -2));
        }
    }

    private final boolean y(MsgElement msgElement, FileElement fileElement) {
        Long l3 = fileElement.expireTime;
        Intrinsics.checkNotNullExpressionValue(l3, "fileElement.expireTime");
        if (l3.longValue() > 0 && vp0.b.e(fileElement)) {
            String q16 = GuildChatPicDownloader.f112420a.q(msgElement, PicSize.PIC_DOWNLOAD_AIO);
            if (TextUtils.isEmpty(q16) || !new File(q16).exists()) {
                QLog.i("GuildFileViewer", 1, "shouldLoadFilePic = false, expireTime: " + fileElement.expireTime + ", elementId = " + msgElement.elementId + ", path: " + q16);
                return false;
            }
        }
        return true;
    }

    private final void z() {
        String string;
        FileElement fileElement;
        MsgElement msgElement = this.element;
        if (msgElement != null && (fileElement = msgElement.fileElement) != null) {
            String a16 = vp0.a.a(fileElement.fileSize, i().g().getContext().getResources().getDisplayMetrics().densityDpi);
            Intrinsics.checkNotNullExpressionValue(a16, "formatFileSizeNotSync(it.fileSize, dpi)");
            this.tvDescText = a16;
        }
        if (this.currentMsgItem.isLocalSend()) {
            string = this.contentView.getContext().getString(R.string.f139140ag);
        } else {
            string = this.contentView.getContext().getString(R.string.f139130af);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (currentMsgItem.isLoc\u2026_download_fail)\n        }");
        i().f().setText(this.tvDescText + string);
        Drawable drawable = this.contentView.getContext().getResources().getDrawable(R.drawable.guild_file_download_fail);
        Intrinsics.checkNotNullExpressionValue(drawable, "contentView.context.reso\u2026guild_file_download_fail)");
        drawable.setBounds(0, 0, this.contentView.getContext().getResources().getDimensionPixelSize(R.dimen.f158711n0), this.contentView.getContext().getResources().getDimensionPixelSize(R.dimen.f158711n0));
        i().f().setCompoundDrawables(null, null, drawable, null);
        i().d().setVisibility(8);
    }

    public final void D(@NotNull String msg2, @NotNull Object payload) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(payload, "payload");
        Object context = this.contentView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) context), "GuildFileViewer_updateBindState", Boolean.TRUE, null, null, new GuildFileViewer$updateBindState$1(msg2, this, payload, null), 12, null);
    }

    public final void F(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        FileElement fileElement;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        this.currentMsgItem = (GuildMsgItem) msgItem;
        MsgElement msgElement = this.element;
        if (msgElement != null && (fileElement = msgElement.fileElement) != null) {
            String str = fileElement.fileName;
            Intrinsics.checkNotNullExpressionValue(str, "it.fileName");
            int d16 = vp0.b.d(str);
            if (d16 != 2 && d16 != 0) {
                i().b().setBackgroundDrawable(this.contentView.getResources().getDrawable(R.drawable.guild_aio_friend_bubble_bg));
            }
        }
    }

    public final void G(@NotNull FileTransNotifyInfo fileInfo) {
        FileElement fileElement;
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        MsgElement msgElement = this.element;
        if (msgElement != null && (fileElement = msgElement.fileElement) != null) {
            String str = fileElement.fileName;
            Intrinsics.checkNotNullExpressionValue(str, "it.fileName");
            int d16 = vp0.b.d(str);
            if (d16 != 2 && d16 != 0) {
                E(fileElement, fileInfo);
            }
        }
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final ViewGroup getContentView() {
        return this.contentView;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final Context getContext() {
        return this.context;
    }
}
