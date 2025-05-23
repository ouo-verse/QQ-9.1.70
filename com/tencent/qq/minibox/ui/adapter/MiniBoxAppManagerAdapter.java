package com.tencent.qq.minibox.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import com.tencent.qq.minibox.manager.MiniBoxDownloadTask;
import com.tencent.qq.minibox.ui.adapter.MiniBoxAppManagerAdapter;
import com.tencent.qq.minibox.ui.view.MiniBoxSwipeMenuLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ls3.DownloadFromExt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us3.i;
import us3.q;
import us3.r;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004OPQRB\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0011H\u0003J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0003H\u0003J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0014\u0010\u001f\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dJ\u0014\u0010 \u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001dJ\u0018\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010'\u001a\u00020\u0005J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0017R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R(\u0010?\u001a\b\u0012\u0004\u0012\u00020\u0003088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010C\u001a\b\u0012\u0004\u0012\u00020\r088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R.\u0010K\u001a\u0004\u0018\u00010D2\b\u0010\u001e\u001a\u0004\u0018\u00010D8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J\u00a8\u0006S"}, d2 = {"Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qq/minibox/manager/MiniBoxDownloadTask;", "task", "", "x0", "C0", "", "curFileSize", "totalSize", "", "r0", "Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "appInfo", "Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter$d;", "holder", "", "position", "o0", "Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter$b;", "n0", "viewHolder", "u0", "t0", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "Landroid/content/Context;", "context", "s0", "", "value", "B0", "A0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "type", "onCreateViewHolder", "getItemCount", "getItemViewType", "destroy", "onBindViewHolder", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "curListType", "Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter$c;", "getCallBack", "()Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter$c;", "y0", "(Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter$c;)V", "callBack", "", "D", "Ljava/util/Map;", "viewHolderMap", "", "E", "Ljava/util/List;", "getMDownloadTaskList", "()Ljava/util/List;", "setMDownloadTaskList", "(Ljava/util/List;)V", "mDownloadTaskList", UserInfo.SEX_FEMALE, "getMMiniBoxAppList", "setMMiniBoxAppList", "mMiniBoxAppList", "Lls3/b;", "G", "Lls3/b;", "getMDownloadAction", "()Lls3/b;", "z0", "(Lls3/b;)V", "mDownloadAction", "<init>", "()V", "H", "a", "b", "c", "d", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxAppManagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private c callBack;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ls3.b mDownloadAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int curListType = 1;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<String, b> viewHolderMap = new LinkedHashMap();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<MiniBoxDownloadTask> mDownloadTaskList = new ArrayList();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<VirtualAppInfo> mMiniBoxAppList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010%\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0014\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018\u00a8\u0006>"}, d2 = {"Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qq/minibox/ui/view/MiniBoxSwipeMenuLayout;", "E", "Lcom/tencent/qq/minibox/ui/view/MiniBoxSwipeMenuLayout;", "p", "()Lcom/tencent/qq/minibox/ui/view/MiniBoxSwipeMenuLayout;", "setLayoutRoot", "(Lcom/tencent/qq/minibox/ui/view/MiniBoxSwipeMenuLayout;)V", "layoutRoot", "Lcom/tencent/mobileqq/widget/SquareImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/SquareImageView;", "l", "()Lcom/tencent/mobileqq/widget/SquareImageView;", "setImgAppIcon", "(Lcom/tencent/mobileqq/widget/SquareImageView;)V", "imgAppIcon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "t", "()Landroid/widget/TextView;", "setTvAppName", "(Landroid/widget/TextView;)V", "tvAppName", "H", "r", "setTvAppContent", "tvAppContent", "I", ReportConstant.COSTREPORT_PREFIX, "setTvAppDesc", "tvAppDesc", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setTvAppAction", "tvAppAction", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "setImgDownloading", "(Landroid/widget/ImageView;)V", "imgDownloading", "Landroid/widget/RelativeLayout;", "L", "Landroid/widget/RelativeLayout;", "o", "()Landroid/widget/RelativeLayout;", "setLayoutAction", "(Landroid/widget/RelativeLayout;)V", "layoutAction", "M", "u", "setTvMenuDel", "tvMenuDel", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private MiniBoxSwipeMenuLayout layoutRoot;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private SquareImageView imgAppIcon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView tvAppName;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private TextView tvAppContent;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private TextView tvAppDesc;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private TextView tvAppAction;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private ImageView imgDownloading;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private RelativeLayout layoutAction;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private TextView tvMenuDel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.yet);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.layout_menu_root)");
            this.layoutRoot = (MiniBoxSwipeMenuLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f165772xj4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.img_app_icon)");
            this.imgAppIcon = (SquareImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f1060667p);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_app_name)");
            this.tvAppName = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f1060367m);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_app_content)");
            this.tvAppContent = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f1060567o);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_app_desc)");
            this.tvAppDesc = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.f1060767q);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.tv_app_status_action)");
            this.tvAppAction = (TextView) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.xjg);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.img_downloading)");
            this.imgDownloading = (ImageView) findViewById7;
            View findViewById8 = itemView.findViewById(R.id.lp9);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.layout_action)");
            this.layoutAction = (RelativeLayout) findViewById8;
            View findViewById9 = itemView.findViewById(R.id.f109266fc);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.tv_menu_del)");
            this.tvMenuDel = (TextView) findViewById9;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final SquareImageView getImgAppIcon() {
            return this.imgAppIcon;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ImageView getImgDownloading() {
            return this.imgDownloading;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final RelativeLayout getLayoutAction() {
            return this.layoutAction;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final MiniBoxSwipeMenuLayout getLayoutRoot() {
            return this.layoutRoot;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final TextView getTvAppAction() {
            return this.tvAppAction;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final TextView getTvAppContent() {
            return this.tvAppContent;
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final TextView getTvAppDesc() {
            return this.tvAppDesc;
        }

        @NotNull
        /* renamed from: t, reason: from getter */
        public final TextView getTvAppName() {
            return this.tvAppName;
        }

        @NotNull
        /* renamed from: u, reason: from getter */
        public final TextView getTvMenuDel() {
            return this.tvMenuDel;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter$c;", "", "Landroid/view/View;", "view", "Lcom/tencent/qq/minibox/manager/MiniBoxDownloadTask;", "task", "", "position", "", "Ae", "I8", "k4", "Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "appInfo", "W6", "td", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface c {
        void Ae(@NotNull View view, @NotNull MiniBoxDownloadTask task, int position);

        void I8(@NotNull View view, @NotNull MiniBoxDownloadTask task, int position);

        void W6(@NotNull View view, @NotNull VirtualAppInfo appInfo, int position);

        void k4(@NotNull View view, @NotNull MiniBoxDownloadTask task, int position);

        void td(@NotNull View view, @NotNull VirtualAppInfo appInfo, int position);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010%\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0014\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018\u00a8\u0006>"}, d2 = {"Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qq/minibox/ui/view/MiniBoxSwipeMenuLayout;", "E", "Lcom/tencent/qq/minibox/ui/view/MiniBoxSwipeMenuLayout;", "p", "()Lcom/tencent/qq/minibox/ui/view/MiniBoxSwipeMenuLayout;", "setLayoutRoot", "(Lcom/tencent/qq/minibox/ui/view/MiniBoxSwipeMenuLayout;)V", "layoutRoot", "Lcom/tencent/mobileqq/widget/SquareImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/SquareImageView;", "l", "()Lcom/tencent/mobileqq/widget/SquareImageView;", "setImgAppIcon", "(Lcom/tencent/mobileqq/widget/SquareImageView;)V", "imgAppIcon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "t", "()Landroid/widget/TextView;", "setTvAppName", "(Landroid/widget/TextView;)V", "tvAppName", "H", "r", "setTvAppContent", "tvAppContent", "I", ReportConstant.COSTREPORT_PREFIX, "setTvAppDesc", "tvAppDesc", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setTvAppAction", "tvAppAction", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "setImgDownloading", "(Landroid/widget/ImageView;)V", "imgDownloading", "Landroid/widget/RelativeLayout;", "L", "Landroid/widget/RelativeLayout;", "o", "()Landroid/widget/RelativeLayout;", "setLayoutAction", "(Landroid/widget/RelativeLayout;)V", "layoutAction", "M", "u", "setTvMenuDel", "tvMenuDel", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private MiniBoxSwipeMenuLayout layoutRoot;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private SquareImageView imgAppIcon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView tvAppName;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private TextView tvAppContent;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private TextView tvAppDesc;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private TextView tvAppAction;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private ImageView imgDownloading;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private RelativeLayout layoutAction;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private TextView tvMenuDel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.yet);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.layout_menu_root)");
            this.layoutRoot = (MiniBoxSwipeMenuLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f165772xj4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.img_app_icon)");
            this.imgAppIcon = (SquareImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f1060667p);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_app_name)");
            this.tvAppName = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f1060367m);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_app_content)");
            this.tvAppContent = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f1060567o);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_app_desc)");
            this.tvAppDesc = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.f1060767q);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.tv_app_status_action)");
            this.tvAppAction = (TextView) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.xjg);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.img_downloading)");
            this.imgDownloading = (ImageView) findViewById7;
            View findViewById8 = itemView.findViewById(R.id.lp9);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.layout_action)");
            this.layoutAction = (RelativeLayout) findViewById8;
            View findViewById9 = itemView.findViewById(R.id.f109266fc);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.tv_menu_del)");
            this.tvMenuDel = (TextView) findViewById9;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final SquareImageView getImgAppIcon() {
            return this.imgAppIcon;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ImageView getImgDownloading() {
            return this.imgDownloading;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final RelativeLayout getLayoutAction() {
            return this.layoutAction;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final MiniBoxSwipeMenuLayout getLayoutRoot() {
            return this.layoutRoot;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final TextView getTvAppAction() {
            return this.tvAppAction;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final TextView getTvAppContent() {
            return this.tvAppContent;
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final TextView getTvAppDesc() {
            return this.tvAppDesc;
        }

        @NotNull
        /* renamed from: t, reason: from getter */
        public final TextView getTvAppName() {
            return this.tvAppName;
        }

        @NotNull
        /* renamed from: u, reason: from getter */
        public final TextView getTvMenuDel() {
            return this.tvMenuDel;
        }
    }

    private final void C0(MiniBoxDownloadTask task) {
        b bVar = this.viewHolderMap.get(task.getAppId());
        if (bVar != null) {
            t0(bVar, task);
            u0(bVar, task);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void n0(MiniBoxDownloadTask appInfo, b holder, int position) {
        holder.getTvAppName().setText(appInfo.getAppName());
        holder.getTvAppDesc().setText("");
        holder.getTvAppContent().setText("");
        holder.getTvMenuDel().setText(BaseApplication.getContext().getString(R.string.f1655928y));
        r.f440004a.d(holder.itemView.getContext(), holder.getImgAppIcon(), appInfo.getAppIcon());
        t0(holder, appInfo);
        u0(holder, appInfo);
    }

    private final void o0(final VirtualAppInfo appInfo, final d holder, final int position) {
        r.f440004a.d(holder.itemView.getContext(), holder.getImgAppIcon(), appInfo.getAppIcon());
        holder.getTvAppName().setText(appInfo.getAppName());
        holder.getTvAppContent().setText(q.f440003a.a(appInfo.getPackageName()));
        holder.getTvAppDesc().setText("");
        holder.getImgDownloading().setVisibility(8);
        holder.getLayoutAction().setVisibility(0);
        holder.getTvAppAction().setText(holder.itemView.getContext().getText(R.string.f166402a5));
        holder.getLayoutAction().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qq.minibox.ui.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniBoxAppManagerAdapter.p0(MiniBoxAppManagerAdapter.this, holder, appInfo, position, view);
            }
        });
        holder.getTvMenuDel().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qq.minibox.ui.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniBoxAppManagerAdapter.q0(MiniBoxAppManagerAdapter.d.this, this, appInfo, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(MiniBoxAppManagerAdapter this$0, d this_run, VirtualAppInfo appInfo, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(appInfo, "$appInfo");
        c cVar = this$0.callBack;
        if (cVar != null) {
            cVar.W6(this_run.getLayoutAction(), appInfo, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(d this_run, MiniBoxAppManagerAdapter this$0, VirtualAppInfo appInfo, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appInfo, "$appInfo");
        this_run.getLayoutRoot().g();
        c cVar = this$0.callBack;
        if (cVar != null) {
            cVar.td(this_run.getTvMenuDel(), appInfo, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String r0(long curFileSize, long totalSize) {
        i iVar = i.f439988a;
        return iVar.b(curFileSize) + '/' + iVar.b(totalSize);
    }

    private final String s0(int downloadStatus, Context context) {
        if (downloadStatus != 5) {
            if (downloadStatus != 6) {
                if (downloadStatus != 7) {
                    return "";
                }
                String string = context.getString(R.string.f1654728m);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026me_download_action_retry)");
                return string;
            }
            String string2 = context.getString(R.string.f1654828n);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026me_download_action_start)");
            return string2;
        }
        String string3 = context.getString(R.string.f1654628l);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026e_download_action_resume)");
        return string3;
    }

    @SuppressLint({"SetTextI18n"})
    private final void t0(b viewHolder, MiniBoxDownloadTask appInfo) {
        int i3 = appInfo.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String();
        if (i3 != 0 && i3 != 2) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 == 7) {
                            viewHolder.getTvAppAction().setVisibility(0);
                            viewHolder.getImgDownloading().setVisibility(8);
                            TextView tvAppAction = viewHolder.getTvAppAction();
                            int i16 = appInfo.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String();
                            Context context = viewHolder.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                            tvAppAction.setText(s0(i16, context));
                            viewHolder.getTvAppContent().setText(r0(appInfo.getDownloadFileSize(), appInfo.getFileSize()));
                            viewHolder.getTvAppDesc().setText(BaseApplication.getContext().getString(R.string.f1655028p));
                            return;
                        }
                        return;
                    }
                    viewHolder.getTvAppAction().setVisibility(0);
                    viewHolder.getImgDownloading().setVisibility(8);
                    TextView tvAppAction2 = viewHolder.getTvAppAction();
                    int i17 = appInfo.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String();
                    Context context2 = viewHolder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                    tvAppAction2.setText(s0(i17, context2));
                    viewHolder.getTvAppContent().setText(r0(appInfo.getDownloadFileSize(), appInfo.getFileSize()));
                    viewHolder.getTvAppDesc().setText(BaseApplication.getContext().getString(R.string.f1654928o));
                    return;
                }
                viewHolder.getTvAppAction().setVisibility(0);
                viewHolder.getImgDownloading().setVisibility(8);
                TextView tvAppAction3 = viewHolder.getTvAppAction();
                int i18 = appInfo.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String();
                Context context3 = viewHolder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "itemView.context");
                tvAppAction3.setText(s0(i18, context3));
                viewHolder.getTvAppContent().setText(r0(appInfo.getDownloadFileSize(), appInfo.getFileSize()));
                viewHolder.getTvAppDesc().setText(BaseApplication.getContext().getString(R.string.f1655128q));
                return;
            }
            viewHolder.getTvAppAction().setVisibility(8);
            viewHolder.getImgDownloading().setVisibility(0);
            long fileSize = ((float) (appInfo.getFileSize() - appInfo.getDownloadFileSize())) / ((float) appInfo.getSpeed());
            TextView tvAppContent = viewHolder.getTvAppContent();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(r0(appInfo.getDownloadFileSize(), appInfo.getFileSize()));
            sb5.append(TokenParser.SP);
            sb5.append(BaseApplication.getContext().getString(R.string.f1653828d));
            i iVar = i.f439988a;
            sb5.append(iVar.d(fileSize));
            tvAppContent.setText(sb5.toString());
            viewHolder.getTvAppDesc().setText(iVar.b(appInfo.getSpeed()));
            return;
        }
        viewHolder.getTvAppAction().setVisibility(8);
        viewHolder.getImgDownloading().setVisibility(0);
        viewHolder.getTvAppContent().setText(r0(appInfo.getDownloadFileSize(), appInfo.getFileSize()));
        viewHolder.getTvAppDesc().setText(BaseApplication.getContext().getString(R.string.f166962bn));
    }

    private final void u0(final b viewHolder, final MiniBoxDownloadTask appInfo) {
        viewHolder.getLayoutAction().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qq.minibox.ui.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniBoxAppManagerAdapter.v0(MiniBoxDownloadTask.this, this, viewHolder, view);
            }
        });
        viewHolder.getTvMenuDel().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qq.minibox.ui.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniBoxAppManagerAdapter.w0(MiniBoxAppManagerAdapter.b.this, this, appInfo, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(MiniBoxDownloadTask appInfo, MiniBoxAppManagerAdapter this$0, b this_run, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(appInfo, "$appInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        int i3 = appInfo.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String();
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 == 7) {
                    ls3.b bVar = this$0.mDownloadAction;
                    if (bVar != null) {
                        bVar.b(appInfo.getAppId(), appInfo.getPackageName(), appInfo.getDownloadUrl(), Integer.parseInt(appInfo.getVersionCode()), appInfo.getAppName(), appInfo.getAppIcon(), new DownloadFromExt(appInfo.getScene(), appInfo.getVia(), appInfo.getReportData()));
                    }
                    c cVar = this$0.callBack;
                    if (cVar != null) {
                        cVar.I8(this_run.getLayoutAction(), appInfo, this_run.getPosition());
                    }
                }
            } else {
                c cVar2 = this$0.callBack;
                if (cVar2 != null) {
                    cVar2.k4(this_run.getLayoutAction(), appInfo, this_run.getPosition());
                }
            }
        } else {
            this_run.getLayoutRoot().g();
            ls3.b bVar2 = this$0.mDownloadAction;
            if (bVar2 != null) {
                bVar2.c(appInfo.getPackageName());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(b this_run, MiniBoxAppManagerAdapter this$0, MiniBoxDownloadTask appInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appInfo, "$appInfo");
        this_run.getLayoutRoot().g();
        c cVar = this$0.callBack;
        if (cVar != null) {
            cVar.Ae(this_run.getTvMenuDel(), appInfo, this_run.getPosition());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void x0(MiniBoxDownloadTask task) {
        int i3 = 0;
        for (Object obj : this.mDownloadTaskList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MiniBoxDownloadTask miniBoxDownloadTask = (MiniBoxDownloadTask) obj;
            if (Intrinsics.areEqual(task.getAppId(), miniBoxDownloadTask.getAppId())) {
                miniBoxDownloadTask.r0(task.getSpeed());
                miniBoxDownloadTask.o0(task.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String());
                miniBoxDownloadTask.p0(task.getFileSize());
                miniBoxDownloadTask.n0(task.getDownloadFileSize());
                miniBoxDownloadTask.q0(task.getProgress());
            }
            i3 = i16;
        }
        C0(task);
    }

    public final void A0(@NotNull List<? extends VirtualAppInfo> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mMiniBoxAppList.clear();
        this.mMiniBoxAppList.addAll(value);
        this.curListType = 1;
        this.viewHolderMap.clear();
        notifyDataSetChanged();
    }

    public final void B0(@NotNull List<MiniBoxDownloadTask> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mDownloadTaskList.clear();
        this.mDownloadTaskList.addAll(value);
        this.curListType = 2;
        this.viewHolderMap.clear();
        notifyDataSetChanged();
    }

    public final void destroy() {
        this.viewHolderMap.clear();
        this.mDownloadTaskList.clear();
        ls3.b bVar = this.mDownloadAction;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.curListType == 2) {
            return this.mDownloadTaskList.size();
        }
        return this.mMiniBoxAppList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.curListType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof b) {
            MiniBoxDownloadTask miniBoxDownloadTask = this.mDownloadTaskList.get(position);
            this.viewHolderMap.put(miniBoxDownloadTask.getAppId(), holder);
            n0(miniBoxDownloadTask, (b) holder, position);
        } else if (holder instanceof d) {
            o0(this.mMiniBoxAppList.get(position), (d) holder, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int type) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (type == 2) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fhz, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new b(itemView);
        }
        View leftView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fhz, parent, false);
        Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
        return new d(leftView);
    }

    public final void y0(@Nullable c cVar) {
        this.callBack = cVar;
    }

    public final void z0(@Nullable ls3.b bVar) {
        this.mDownloadAction = bVar;
        if (bVar != null) {
            bVar.a(new MiniBoxAppManagerAdapter$mDownloadAction$1(this));
        }
    }
}
