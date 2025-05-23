package gk4;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.pendant.PendantViewData;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.pendant.webview.QQLivePendantWebViewDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u000b\b\u0016\u0018\u0000 %2\u00020\u0001:\u0002&'B\u0007\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\f\u001a\u00020\u000b2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\tH\u0002J(\u0010\r\u001a\u00020\u000b2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\tH\u0002J\u001a\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J2\u0010\u0012\u001a\u0004\u0018\u00010\b2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J(\u0010\u0018\u001a\u00020\u000b2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\tH\u0014J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016R&\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u001d8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lgk4/b;", "Lgk4/a;", "", "pendentPosition", "Landroid/view/View;", "pendentViewStub", "D", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/pendant/PendantViewData;", "Lkotlin/collections/ArrayList;", "pendantViewDataList", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "data", "viewPosition", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "targetViewPos", HippyTKDListViewAdapter.X, "Lgk4/b$b;", "holder", BdhLogUtil.LogTag.Tag_Conn, "E", UserInfo.SEX_FEMALE, "d", "", NodeProps.VISIBLE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "", "K", "Ljava/util/Map;", "y", "()Ljava/util/Map;", "pendantViewHolders", "<init>", "()V", "L", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class b extends a {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Map<Long, PendantViewHolder> pendantViewHolders = new LinkedHashMap();

    private final void A(ArrayList<PendantViewData> pendantViewDataList) {
        z(x(pendantViewDataList, 1L), 1L);
    }

    private final void B(ArrayList<PendantViewData> pendantViewDataList) {
        z(x(pendantViewDataList, 7L), 7L);
    }

    private final void C(PendantViewHolder holder) {
        if (holder == null) {
            return;
        }
        QQLivePendantWebViewDelegate pendant = holder.getPendant();
        if (pendant != null) {
            pendant.w();
        }
        holder.e(null);
        FrameLayout container = holder.getContainer();
        if (container != null) {
            container.setVisibility(8);
            if (container.getChildCount() > 0) {
                container.removeAllViews();
            }
        }
    }

    private final b D(long pendentPosition, View pendentViewStub) {
        if (pendentViewStub instanceof ViewStub) {
            this.pendantViewHolders.put(Long.valueOf(pendentPosition), new PendantViewHolder((ViewStub) pendentViewStub, null, null, 6, null));
        }
        return this;
    }

    private final PendantViewData x(ArrayList<PendantViewData> pendantViewDataList, long targetViewPos) {
        Object obj;
        if (pendantViewDataList == null) {
            return null;
        }
        Iterator<T> it = pendantViewDataList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                PendantViewData pendantViewData = (PendantViewData) obj;
                boolean z16 = false;
                if (pendantViewData == null) {
                    AegisLogger.INSTANCE.i("Pendant|PendantManager", "getPendantViewData", "pendant info is null");
                } else if (pendantViewData.viewPosition == targetViewPos) {
                    z16 = true;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        PendantViewData pendantViewData2 = (PendantViewData) obj;
        if (pendantViewData2 == null) {
            return null;
        }
        if (!k(pendantViewData2)) {
            AegisLogger.INSTANCE.i("Pendant|PendantManager", "getPendantViewData", "pendant info is not Valid");
            return null;
        }
        n(pendantViewData2);
        return pendantViewData2;
    }

    private final void z(PendantViewData data, long viewPosition) {
        View view;
        PendantViewHolder pendantViewHolder = this.pendantViewHolders.get(Long.valueOf(viewPosition));
        if (pendantViewHolder == null) {
            return;
        }
        if (data == null) {
            C(pendantViewHolder);
            return;
        }
        if (pendantViewHolder.getContainer() == null) {
            ViewStub viewStub = pendantViewHolder.getViewStub();
            FrameLayout frameLayout = null;
            if (viewStub != null) {
                view = viewStub.inflate();
            } else {
                view = null;
            }
            if (view instanceof FrameLayout) {
                frameLayout = (FrameLayout) view;
            }
            pendantViewHolder.d(frameLayout);
        }
        if (pendantViewHolder.getPendant() == null) {
            pendantViewHolder.e(e(data, pendantViewHolder.getContainer()));
        } else {
            QQLivePendantWebViewDelegate pendant = pendantViewHolder.getPendant();
            if (pendant != null) {
                FrameLayout container = pendantViewHolder.getContainer();
                Intrinsics.checkNotNull(container);
                pendant.y(data, container);
            }
        }
        v(pendantViewHolder.getContainer(), true);
    }

    @NotNull
    public final b E(@Nullable View pendentViewStub) {
        return D(1L, pendentViewStub);
    }

    @NotNull
    public final b F(@Nullable View pendentViewStub) {
        return D(7L, pendentViewStub);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gk4.a
    public void d(@Nullable ArrayList<PendantViewData> pendantViewDataList) {
        super.d(pendantViewDataList);
        A(pendantViewDataList);
        B(pendantViewDataList);
    }

    @Override // gk4.a
    public void q(boolean visible) {
        super.q(visible);
        Iterator<Map.Entry<Long, PendantViewHolder>> it = this.pendantViewHolders.entrySet().iterator();
        while (it.hasNext()) {
            FrameLayout container = it.next().getValue().getContainer();
            if (container != null) {
                v(container, visible);
            }
        }
    }

    @Override // gk4.a
    public void w() {
        super.w();
        Iterator<Map.Entry<Long, PendantViewHolder>> it = this.pendantViewHolders.entrySet().iterator();
        while (it.hasNext()) {
            C(it.next().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Map<Long, PendantViewHolder> y() {
        return this.pendantViewHolders;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u0012\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lgk4/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/ViewStub;", "a", "Landroid/view/ViewStub;", "c", "()Landroid/view/ViewStub;", "setViewStub", "(Landroid/view/ViewStub;)V", "viewStub", "Landroid/widget/FrameLayout;", "b", "Landroid/widget/FrameLayout;", "()Landroid/widget/FrameLayout;", "d", "(Landroid/widget/FrameLayout;)V", ParseCommon.CONTAINER, "Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate;", "Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate;", "()Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate;", "e", "(Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate;)V", IndividuationUrlHelper.UrlId.PENDANT_HOME, "<init>", "(Landroid/view/ViewStub;Landroid/widget/FrameLayout;Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLivePendantWebViewDelegate;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gk4.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes26.dex */
    public static final /* data */ class PendantViewHolder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private ViewStub viewStub;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private FrameLayout container;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private QQLivePendantWebViewDelegate pendant;

        public PendantViewHolder(@Nullable ViewStub viewStub, @Nullable FrameLayout frameLayout, @Nullable QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate) {
            this.viewStub = viewStub;
            this.container = frameLayout;
            this.pendant = qQLivePendantWebViewDelegate;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final FrameLayout getContainer() {
            return this.container;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final QQLivePendantWebViewDelegate getPendant() {
            return this.pendant;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final ViewStub getViewStub() {
            return this.viewStub;
        }

        public final void d(@Nullable FrameLayout frameLayout) {
            this.container = frameLayout;
        }

        public final void e(@Nullable QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate) {
            this.pendant = qQLivePendantWebViewDelegate;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendantViewHolder)) {
                return false;
            }
            PendantViewHolder pendantViewHolder = (PendantViewHolder) other;
            if (Intrinsics.areEqual(this.viewStub, pendantViewHolder.viewStub) && Intrinsics.areEqual(this.container, pendantViewHolder.container) && Intrinsics.areEqual(this.pendant, pendantViewHolder.pendant)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            ViewStub viewStub = this.viewStub;
            int i3 = 0;
            if (viewStub == null) {
                hashCode = 0;
            } else {
                hashCode = viewStub.hashCode();
            }
            int i16 = hashCode * 31;
            FrameLayout frameLayout = this.container;
            if (frameLayout == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = frameLayout.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate = this.pendant;
            if (qQLivePendantWebViewDelegate != null) {
                i3 = qQLivePendantWebViewDelegate.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "PendantViewHolder(viewStub=" + this.viewStub + ", container=" + this.container + ", pendant=" + this.pendant + ")";
        }

        public /* synthetic */ PendantViewHolder(ViewStub viewStub, FrameLayout frameLayout, QQLivePendantWebViewDelegate qQLivePendantWebViewDelegate, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewStub, (i3 & 2) != 0 ? null : frameLayout, (i3 & 4) != 0 ? null : qQLivePendantWebViewDelegate);
        }
    }
}
