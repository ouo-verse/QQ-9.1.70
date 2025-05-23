package com.tencent.mobileqq.qqlive.sail.ui.close;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\f\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0003H\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/qqlive/sail/ui/close/n;", "", "itemWidth", "i0", "j0", "", "Lqr4/b;", "newFeeds", "", "setData", "Lcom/tencent/mobileqq/qqlive/sail/ui/close/a$b;", "listener", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "getItemCount", "holder", "position", "k0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "feeds", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/sail/ui/close/a$b;", "clickListener", "<init>", "()V", "D", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends RecyclerView.Adapter<n> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b clickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<qr4.b> feeds;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/a$a;", "", "", "ITEM_VIEW_SIZE_RATIO", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.close.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/a$b;", "", "Lqr4/b;", "feed", "", "p5", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void p5(@Nullable qr4.b feed);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51597);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.feeds = new ArrayList();
        }
    }

    private final int i0(int itemWidth) {
        return (int) (itemWidth * 1.4195403f);
    }

    private final int j0() {
        float f16 = 2;
        float screenWidth = ((ViewUtils.getScreenWidth() - (BaseApplication.getContext().getResources().getDimension(R.dimen.d75) * f16)) - com.tencent.mobileqq.qqlive.sail.ui.close.b.INSTANCE.a()) / f16;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            companion.d("Audience|EndRecommendAdapter", "computeItemWidth", "width=" + screenWidth);
        }
        return (int) screenWidth;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.feeds.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull n holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder, position);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.m(this.feeds.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public n onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (n) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.h9l, parent, false);
        int j06 = j0();
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        layoutParams.width = j06;
        layoutParams.height = i0(j06);
        itemView.setLayoutParams(layoutParams);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new n(itemView, this.clickListener);
    }

    public final void m0(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            this.clickListener = listener;
        }
    }

    public final void setData(@NotNull List<qr4.b> newFeeds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) newFeeds);
            return;
        }
        Intrinsics.checkNotNullParameter(newFeeds, "newFeeds");
        if (this.feeds.size() >= 4) {
            AegisLogger.INSTANCE.i("Audience|EndRecommendAdapter", "setData", "already have feeds list");
            return;
        }
        this.feeds.clear();
        this.feeds.addAll(newFeeds);
        notifyItemChanged(0);
    }
}
