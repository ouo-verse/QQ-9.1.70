package com.tencent.mobileqq.aio.panel.photo;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.panel.photo.g;
import com.tencent.mobileqq.album.api.IAlbumApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.customization.SendByFile;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.ag;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B\u0017\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\b=\u0010>J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bJ\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0014J\u0006\u0010\u0016\u001a\u00020\u0007J,\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\tJ\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\tH\u0016J&\u0010&\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0018H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\tH\u0016R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R&\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000501j\b\u0012\u0004\u0012\u00020\u0005`28\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R0\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/aio/panel/photo/r;", "Landroid/widget/ImageView;", "iv", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "w0", "", "type", "", "duration", "v0", "", "n0", "originPath", "editPath", "l0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "o0", "m0", "mediaInfos", "", "needRefreshMedias", "refreshTag", "", "x0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "u0", "holder", "position", "p0", "", "payloads", "q0", "getItemViewType", "getItemCount", "Lcom/tencent/mobileqq/aio/panel/photo/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/panel/photo/a;", "mPhotoPanel", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVM;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVM;", "viewModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "mLocalMediaInfos", "Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", "E", "Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", "sendByFile", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "replaceMap", "<init>", "(Lcom/tencent/mobileqq/aio/panel/photo/a;Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVM;)V", "G", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PhotoPanelAdapter extends RecyclerView.Adapter<r> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final PhotoPanelVM viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ArrayList<LocalMediaInfo> mLocalMediaInfos;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final SendByFile sendByFile;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, String> replaceMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mPhotoPanel;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelAdapter$a;", "", "", "ITEM_SELECTED_COLOR", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.panel.photo.PhotoPanelAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64483);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PhotoPanelAdapter(@NotNull a mPhotoPanel, @NotNull PhotoPanelVM viewModel) {
        Intrinsics.checkNotNullParameter(mPhotoPanel, "mPhotoPanel");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mPhotoPanel, (Object) viewModel);
            return;
        }
        this.mPhotoPanel = mPhotoPanel;
        this.viewModel = viewModel;
        this.mLocalMediaInfos = new ArrayList<>();
        this.sendByFile = new SendByFile(0L, 0L, 0L, 0, 0, false, 63, null);
        this.replaceMap = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(PhotoPanelAdapter this$0, LocalMediaInfo mediaInfo, CheckBox this_apply, r holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.CheckBox");
        if (!((CheckBox) view).isChecked()) {
            this$0.mPhotoPanel.v0(new g.f(mediaInfo));
        } else if (this$0.mPhotoPanel.e0(mediaInfo)) {
            this$0.mPhotoPanel.v0(new g.a(mediaInfo));
            SendByFile sendByFile = this$0.sendByFile;
            Context context = this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            sendByFile.f(context, mediaInfo, true, this$0.viewModel.C());
        } else {
            holder.l().setChecked(false);
            QQToast.makeText(this_apply.getContext(), R.string.f174352vm, 1).show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(PhotoPanelAdapter this$0, LocalMediaInfo mediaInfo, CheckBox this_apply, r holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.CheckBox");
        if (!((CheckBox) view).isChecked()) {
            this$0.mPhotoPanel.v0(new g.f(mediaInfo));
        } else if (this$0.mPhotoPanel.e0(mediaInfo)) {
            this$0.mPhotoPanel.v0(new g.a(mediaInfo));
            SendByFile sendByFile = this$0.sendByFile;
            Context context = this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            sendByFile.f(context, mediaInfo, true, this$0.viewModel.C());
        } else {
            holder.l().setChecked(false);
            QQToast.makeText(this_apply.getContext(), R.string.f174352vm, 1).show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(PhotoPanelAdapter this$0, final LocalMediaInfo mediaInfo, r holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (!FastClickUtils.isFastDoubleClick("PhotoPanelAdapter")) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            final Ref.IntRef intRef = new Ref.IntRef();
            int indexOf = this$0.mLocalMediaInfos.indexOf(mediaInfo);
            intRef.element = indexOf;
            if (indexOf == -1) {
                ox3.a.c("PhotoPanelAdapter", new Function0<String>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelAdapter$onBindViewHolder$4$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return "pos=-1, info=" + LocalMediaInfo.this.getPath() + ", use 0";
                    }
                });
                intRef.element = 0;
            }
            ox3.a.c("PhotoPanelAdapter", new Function0<String>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelAdapter$onBindViewHolder$4$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) Ref.IntRef.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "onItemClick pos:" + Ref.IntRef.this.element;
                }
            });
            this$0.viewModel.Q(intRef.element, rect, holder.o());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String v0(int type, LocalMediaInfo mediaInfo, String duration) {
        CharSequence f16 = en.f(BaseApplication.getContext(), 3, mediaInfo.getModifiedDate() * 1000, true, true);
        if (type != 0) {
            if (type != 1) {
                return "";
            }
            return HardCodeUtil.qqStr(R.string.ypf) + "," + HardCodeUtil.qqStr(R.string.f174262vd) + ((Object) f16) + "," + HardCodeUtil.qqStr(R.string.f174312vi) + duration;
        }
        return HardCodeUtil.qqStr(R.string.f174292vg) + "," + HardCodeUtil.qqStr(R.string.f174262vd) + ((Object) f16);
    }

    private final void w0(ImageView iv5, LocalMediaInfo mediaInfo) {
        if (this.replaceMap.containsKey(mediaInfo.getPath())) {
            com.tencent.qqnt.qbasealbum.ktx.b.r(mediaInfo, true);
            mediaInfo.setSystemMeidaStore(false);
            mediaInfo.setPicPathBeforeEdit(mediaInfo.getPath());
            mediaInfo.setPath(this.replaceMap.get(mediaInfo.getPath()));
        }
        com.tencent.qqnt.qbasealbum.ktx.d.c(iv5, mediaInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mLocalMediaInfos.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, position)).intValue();
        }
        return this.mLocalMediaInfos.get(position).getMMediaType();
    }

    public final void l0(@NotNull String originPath, @NotNull String editPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) originPath, (Object) editPath);
            return;
        }
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        Intrinsics.checkNotNullParameter(editPath, "editPath");
        this.replaceMap.put(originPath, editPath);
    }

    public final void m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.replaceMap.clear();
        }
    }

    @NotNull
    public final List<LocalMediaInfo> n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mLocalMediaInfos;
    }

    @NotNull
    public final HashMap<String, String> o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.replaceMap;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final r holder, int position) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 8;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        LocalMediaInfo localMediaInfo = this.mLocalMediaInfos.get(position);
        Intrinsics.checkNotNullExpressionValue(localMediaInfo, "mLocalMediaInfos[position]");
        final LocalMediaInfo localMediaInfo2 = localMediaInfo;
        holder.s(localMediaInfo2);
        URLImageView o16 = holder.o();
        ViewGroup.LayoutParams layoutParams = o16.getLayoutParams();
        if (layoutParams.height != -1 || layoutParams.width != -1) {
            layoutParams.height = -1;
            layoutParams.width = -1;
            o16.setLayoutParams(layoutParams);
        }
        w0(o16, localMediaInfo2);
        int itemViewType = getItemViewType(position);
        String str = "";
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                holder.q().setVisibility(4);
            } else {
                TextView q16 = holder.q();
                Drawable drawable = ContextCompat.getDrawable(q16.getContext(), R.drawable.qui_play_filled_icon_white);
                if (drawable != null) {
                    drawable.setBounds(0, 0, com.tencent.qqnt.qbasealbum.ktx.d.b(12), com.tencent.qqnt.qbasealbum.ktx.d.b(12));
                }
                q16.setCompoundDrawables(drawable, null, null, null);
                q16.setCompoundDrawablePadding(com.tencent.qqnt.qbasealbum.ktx.d.b(2));
                q16.setVisibility(0);
                q16.setText(((IAlbumApi) QRoute.api(IAlbumApi.class)).formatTimeToString(com.tencent.qqnt.qbasealbum.ktx.b.f(localMediaInfo2)));
                o16.setContentDescription(v0(getItemViewType(position), localMediaInfo2, q16.getText().toString()));
                holder.l().setContentDescription(v0(getItemViewType(position), localMediaInfo2, q16.getText().toString()));
                q16.setImportantForAccessibility(2);
            }
        } else {
            holder.q().setVisibility(4);
            o16.setContentDescription(v0(getItemViewType(position), localMediaInfo2, ""));
            holder.l().setContentDescription(v0(getItemViewType(position), localMediaInfo2, ""));
        }
        final CheckBox l3 = holder.l();
        List<LocalMediaInfo> E0 = this.mPhotoPanel.E0();
        l3.setChecked(E0.contains(localMediaInfo2));
        if (l3.isChecked()) {
            str = String.valueOf(E0.indexOf(localMediaInfo2) + 1);
        }
        l3.setText(str);
        l3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.panel.photo.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPanelAdapter.s0(PhotoPanelAdapter.this, localMediaInfo2, l3, holder, view);
            }
        });
        ImageView m3 = holder.m();
        if (com.tencent.qqnt.qbasealbum.ktx.b.j(localMediaInfo2)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        m3.setVisibility(i3);
        ImageView p16 = holder.p();
        if (holder.l().isChecked()) {
            p16.setBackgroundColor(855638016);
            i16 = 0;
        }
        p16.setVisibility(i16);
        View view = holder.itemView;
        view.setTranslationY(0.0f);
        view.setTranslationY(0.0f);
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setOutlineProvider(null);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.panel.photo.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PhotoPanelAdapter.t0(PhotoPanelAdapter.this, localMediaInfo2, holder, view2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final r holder, int position, @NotNull List<Object> payloads) {
        boolean z16;
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
            return;
        }
        LocalMediaInfo localMediaInfo = this.mLocalMediaInfos.get(position);
        Intrinsics.checkNotNullExpressionValue(localMediaInfo, "mLocalMediaInfos[position]");
        final LocalMediaInfo localMediaInfo2 = localMediaInfo;
        if (payloads.contains(2)) {
            w0(holder.o(), localMediaInfo2);
            ImageView m3 = holder.m();
            if (com.tencent.qqnt.qbasealbum.ktx.b.j(localMediaInfo2)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            m3.setVisibility(i3);
        }
        if (payloads.contains(1)) {
            final CheckBox l3 = holder.l();
            List<LocalMediaInfo> E0 = this.mPhotoPanel.E0();
            if (E0.contains(localMediaInfo2)) {
                z16 = true;
            } else {
                z16 = false;
            }
            l3.setChecked(z16);
            if (l3.isChecked()) {
                str = String.valueOf(E0.indexOf(localMediaInfo2) + 1);
            } else {
                str = "";
            }
            l3.setText(str);
            l3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.panel.photo.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotoPanelAdapter.r0(PhotoPanelAdapter.this, localMediaInfo2, l3, holder, view);
                }
            });
            ImageView p16 = holder.p();
            if (holder.l().isChecked()) {
                p16.setBackgroundColor(855638016);
            } else {
                i16 = 8;
            }
            p16.setVisibility(i16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public r onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (r) iPatchRedirector.redirect((short) 7, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        RelativeLayout root = ag.g(LayoutInflater.from(parent.getContext()), parent, false).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(LayoutInflater.f\u2026ext), parent, false).root");
        return new r(root);
    }

    public final boolean x0(@NotNull List<LocalMediaInfo> mediaInfos, @Nullable List<LocalMediaInfo> needRefreshMedias, int refreshTag) {
        Object obj;
        Object orNull;
        String str;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, mediaInfos, needRefreshMedias, Integer.valueOf(refreshTag))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        if (needRefreshMedias != null) {
            Iterator<LocalMediaInfo> it = needRefreshMedias.iterator();
            while (it.hasNext()) {
                notifyItemChanged(this.mLocalMediaInfos.indexOf(it.next()), Integer.valueOf(refreshTag));
            }
            return false;
        }
        if (this.mLocalMediaInfos.size() == 0) {
            this.mLocalMediaInfos.addAll(mediaInfos);
            notifyItemRangeInserted(0, mediaInfos.size());
            return false;
        }
        List<LocalMediaInfo> list = mediaInfos;
        Iterator<T> it5 = list.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj = it5.next();
                if (this.replaceMap.containsKey(((LocalMediaInfo) obj).getPath())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
        if (localMediaInfo != null) {
            com.tencent.qqnt.qbasealbum.ktx.b.r(localMediaInfo, true);
            localMediaInfo.setSystemMeidaStore(false);
            localMediaInfo.setPicPathBeforeEdit(localMediaInfo.getPath());
            localMediaInfo.setPath(this.replaceMap.get(localMediaInfo.getPath()));
        }
        for (LocalMediaInfo localMediaInfo2 : this.mPhotoPanel.E0()) {
            Iterator<T> it6 = list.iterator();
            while (true) {
                if (it6.hasNext()) {
                    obj2 = it6.next();
                    if (Intrinsics.areEqual(localMediaInfo2.getPath(), ((LocalMediaInfo) obj2).getPath())) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            if (((LocalMediaInfo) obj2) == null) {
                this.mPhotoPanel.v0(new g.f(localMediaInfo2));
            }
        }
        int size = mediaInfos.size();
        boolean z16 = false;
        for (final int i3 = 0; i3 < size; i3++) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.mLocalMediaInfos, i3);
            LocalMediaInfo localMediaInfo3 = (LocalMediaInfo) orNull;
            if (localMediaInfo3 != null) {
                str = localMediaInfo3.getPath();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, mediaInfos.get(i3).getPath())) {
                final Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = -1;
                int i16 = 0;
                for (Object obj3 : this.mLocalMediaInfos) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (Intrinsics.areEqual(((LocalMediaInfo) obj3).getPath(), mediaInfos.get(i3).getPath())) {
                        intRef.element = i16;
                    }
                    i16 = i17;
                }
                int i18 = intRef.element;
                if (i18 == -1) {
                    if (i3 >= this.mLocalMediaInfos.size()) {
                        this.mLocalMediaInfos.add(mediaInfos.get(i3));
                        notifyItemInserted(this.mLocalMediaInfos.size() - 1);
                    } else {
                        this.mLocalMediaInfos.add(i3, mediaInfos.get(i3));
                        notifyItemInserted(i3);
                    }
                } else if (i18 > i3) {
                    this.mLocalMediaInfos.subList(i3, i18).clear();
                    notifyItemRangeRemoved(i3, intRef.element);
                } else if (!com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    ox3.a.f("PhotoPanelAdapter", new Function0<String>(i3) { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelAdapter$submitData$5
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int $index;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$index = i3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Ref.IntRef.this, i3);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "submitData, findId=" + Ref.IntRef.this.element + ", index=" + this.$index;
                        }
                    });
                } else {
                    throw new RuntimeException("WTF");
                }
                z16 = true;
            }
        }
        if (this.mLocalMediaInfos.size() > size) {
            ArrayList<LocalMediaInfo> arrayList = this.mLocalMediaInfos;
            List<LocalMediaInfo> subList = arrayList.subList(size, arrayList.size());
            Intrinsics.checkNotNullExpressionValue(subList, "mLocalMediaInfos.subList\u2026e, mLocalMediaInfos.size)");
            int size2 = subList.size();
            subList.clear();
            notifyItemRangeRemoved(size, size2);
            return true;
        }
        return z16;
    }
}
