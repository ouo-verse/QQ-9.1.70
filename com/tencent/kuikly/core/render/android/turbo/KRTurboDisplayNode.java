package com.tencent.kuikly.core.render.android.turbo;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b&\u0018\u0000 g2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010X\u001a\u00020\u0002\u0012\u0006\u0010^\u001a\u00020\u0004\u00a2\u0006\u0004\bd\u0010eB\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\bd\u0010fJW\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0016\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0000JE\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rJM\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rJ\u0018\u0010\"\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\tJ\u000e\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020#J\u000e\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020&J \u0010*\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010)\u001a\u00020\u0002J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020\u0000J\u0006\u0010/\u001a\u00020.R$\u00106\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0000078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R(\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0011078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R(\u0010F\u001a\b\u0012\u0004\u0012\u00020B078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u00108\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R$\u0010M\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010R\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010N\u001a\u0004\b>\u0010O\"\u0004\bP\u0010QR\"\u0010X\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bS\u0010WR\"\u0010^\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\bY\u0010]R\u0011\u0010`\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b_\u0010VR\u0011\u0010c\u001a\u00020#8F\u00a2\u0006\u0006\u001a\u0004\ba\u0010b\u00a8\u0006h"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;", "Landroid/os/Parcelable;", "", "type", "", "name", "method", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "b", "key", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayProp;", "l", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "subNode", "index", "t", "parentNode", "u", "c", "moduleName", "a", "propKey", "propValue", "y", "Landroid/graphics/RectF;", AIInput.KEY_FRAME, "w", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayShadow;", "shadow", "B", "propType", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", ReportConstant.COSTREPORT_PREFIX, "e", "", "E", "d", "Ljava/lang/Integer;", "k", "()Ljava/lang/Integer;", HippyTKDListViewAdapter.X, "(Ljava/lang/Integer;)V", "parentTag", "", "Ljava/util/List;", "j", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", Node.CHILDREN_ATTR, "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setProps", "props", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNodeMethod;", h.F, "g", "setCallMethods", "callMethods", "i", "Ljava/lang/Object;", "o", "()Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;)V", "renderShadow", "Z", "()Z", "v", "(Z)V", "addViewMethodDisable", BdhLogUtil.LogTag.Tag_Conn, "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()I", "(I)V", "tag", "D", "Ljava/lang/String;", "r", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "viewName", "p", "scrollIndex", DomainData.DOMAIN_NAME, "()Landroid/graphics/RectF;", "renderFrame", "<init>", "(ILjava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRTurboDisplayNode implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private int tag;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String viewName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer parentTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<KRTurboDisplayNode> children;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<KRTurboDisplayProp> props;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<KRTurboDisplayNodeMethod> callMethods;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object renderShadow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean addViewMethodDisable;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;", "Landroid/os/Parcel;", "parcel", "b", "", "size", "", "c", "(I)[Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;", "", "data", "a", "", "FRAME_KEY", "Ljava/lang/String;", "INSERT_KEY", "SCROLL_INDEX", "SHADOW_KEY", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayNode$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion implements Parcelable.Creator<KRTurboDisplayNode> {
        Companion() {
        }

        @Nullable
        public final KRTurboDisplayNode a(@NotNull byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
            obtain.unmarshall(data, 0, data.length);
            obtain.setDataPosition(0);
            KRTurboDisplayNode createFromParcel = createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            return createFromParcel;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KRTurboDisplayNode createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new KRTurboDisplayNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public KRTurboDisplayNode[] newArray(int size) {
            return new KRTurboDisplayNode[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KRTurboDisplayNode(int i3, @NotNull String viewName) {
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        this.tag = i3;
        this.viewName = viewName;
        this.children = new ArrayList();
        this.props = new ArrayList();
        this.callMethods = new ArrayList();
    }

    private final void b(int type, String name, String method, String params, Function1<Object, Unit> callback) {
        KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod = new KRTurboDisplayNodeMethod();
        kRTurboDisplayNodeMethod.m(type);
        kRTurboDisplayNodeMethod.k(name);
        kRTurboDisplayNodeMethod.j(method);
        kRTurboDisplayNodeMethod.l(params);
        kRTurboDisplayNodeMethod.g(callback);
        this.callMethods.add(kRTurboDisplayNodeMethod);
    }

    private final KRTurboDisplayProp l(String key) {
        if (this.props.isEmpty()) {
            return null;
        }
        for (KRTurboDisplayProp kRTurboDisplayProp : this.props) {
            if (Intrinsics.areEqual(kRTurboDisplayProp.getPropKey(), key)) {
                return kRTurboDisplayProp;
            }
        }
        return null;
    }

    public final void A(@Nullable Object obj) {
        this.renderShadow = obj;
    }

    public final void B(@NotNull KRTurboDisplayShadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        z("shadow", shadow, 3);
    }

    public final void C(int i3) {
        this.tag = i3;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.viewName = str;
    }

    @NotNull
    public final byte[] E() {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
        writeToParcel(obtain, 0);
        byte[] data = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        Intrinsics.checkNotNullExpressionValue(data, "data");
        return data;
    }

    public final void a(@NotNull String moduleName, @NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(method, "method");
        b(1, moduleName, method, params, callback);
    }

    public final void c(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        b(0, "", method, params, callback);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final KRTurboDisplayNode e() {
        KRTurboDisplayNode kRTurboDisplayNode = new KRTurboDisplayNode(this.tag, this.viewName);
        kRTurboDisplayNode.parentTag = this.parentTag;
        if (!this.children.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<KRTurboDisplayNode> it = this.children.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().e());
            }
            kRTurboDisplayNode.children = arrayList;
        }
        if (!this.props.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<KRTurboDisplayProp> it5 = this.props.iterator();
            while (it5.hasNext()) {
                arrayList2.add(it5.next().b());
            }
            kRTurboDisplayNode.props = arrayList2;
        }
        if (!this.callMethods.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<KRTurboDisplayNodeMethod> it6 = this.callMethods.iterator();
            while (it6.hasNext()) {
                arrayList3.add(it6.next().a());
            }
            kRTurboDisplayNode.callMethods = arrayList3;
        }
        return kRTurboDisplayNode;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getAddViewMethodDisable() {
        return this.addViewMethodDisable;
    }

    @NotNull
    public final List<KRTurboDisplayNodeMethod> g() {
        return this.callMethods;
    }

    @NotNull
    public final List<KRTurboDisplayNode> j() {
        return this.children;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final Integer getParentTag() {
        return this.parentTag;
    }

    @NotNull
    public final List<KRTurboDisplayProp> m() {
        return this.props;
    }

    @NotNull
    public final RectF n() {
        for (KRTurboDisplayProp kRTurboDisplayProp : this.props) {
            if (kRTurboDisplayProp.getPropType() == 2) {
                Object propValue = kRTurboDisplayProp.getPropValue();
                if (propValue != null) {
                    return (RectF) propValue;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.graphics.RectF");
            }
        }
        return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final Object getRenderShadow() {
        return this.renderShadow;
    }

    public final int p() {
        for (KRTurboDisplayProp kRTurboDisplayProp : this.props) {
            if (Intrinsics.areEqual(kRTurboDisplayProp.getPropKey(), "scrollIndex")) {
                Object propValue = kRTurboDisplayProp.getPropValue();
                if (propValue != null) {
                    return ((Integer) propValue).intValue();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        return 0;
    }

    /* renamed from: q, reason: from getter */
    public final int getTag() {
        return this.tag;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final String getViewName() {
        return this.viewName;
    }

    public final boolean s() {
        return !this.children.isEmpty();
    }

    public final void t(@NotNull KRTurboDisplayNode subNode, int index) {
        int size;
        Intrinsics.checkNotNullParameter(subNode, "subNode");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        if (index <= this.children.size() && index != -1) {
            size = index;
        } else {
            size = this.children.size();
        }
        this.children.add(size, subNode);
        subNode.parentTag = Integer.valueOf(this.tag);
        subNode.z("insert", Integer.valueOf(index), 4);
    }

    public final void u(@NotNull KRTurboDisplayNode parentNode) {
        Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        parentNode.children.remove(this);
        this.parentTag = null;
    }

    public final void v(boolean z16) {
        this.addViewMethodDisable = z16;
    }

    public final void w(@NotNull RectF frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        z(AIInput.KEY_FRAME, frame, 2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.tag);
        parcel.writeString(this.viewName);
        parcel.writeValue(this.parentTag);
        if (!this.props.isEmpty()) {
            parcel.writeInt(1);
            Object[] array = this.props.toArray(new KRTurboDisplayProp[0]);
            if (array != null) {
                parcel.writeParcelableArray((Parcelable[]) array, flags);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            parcel.writeInt(0);
        }
        if (!this.callMethods.isEmpty()) {
            parcel.writeInt(1);
            Object[] array2 = this.callMethods.toArray(new KRTurboDisplayNodeMethod[0]);
            if (array2 != null) {
                parcel.writeParcelableArray((Parcelable[]) array2, flags);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            parcel.writeInt(0);
        }
        if (!this.children.isEmpty()) {
            parcel.writeInt(1);
            Object[] array3 = this.children.toArray(new KRTurboDisplayNode[0]);
            if (array3 != null) {
                parcel.writeParcelableArray((Parcelable[]) array3, flags);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        parcel.writeInt(0);
    }

    public final void x(@Nullable Integer num) {
        this.parentTag = num;
    }

    public final void y(@NotNull String propKey, @Nullable Object propValue) {
        int i3;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        if (propValue instanceof Function) {
            if (Intrinsics.areEqual(propKey, Pager.PAGER_EVENT_SET_NEED_LAYOUT)) {
                return;
            } else {
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        z(propKey, propValue, i3);
    }

    public final void z(@NotNull String propKey, @Nullable Object propValue, int propType) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        KRTurboDisplayProp l3 = l(propKey);
        if (l3 == null) {
            this.props.add(new KRTurboDisplayProp(propType, propKey, propValue));
        } else {
            l3.m(propValue);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KRTurboDisplayNode(@NotNull Parcel parcel) {
        this(r0, r1);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        Intrinsics.checkNotNullExpressionValue(readString, "parcel.readString() ?: \"\"");
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        this.parentTag = (Integer) (readValue instanceof Integer ? readValue : null);
        if (parcel.readInt() == 1) {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(KRTurboDisplayNode.class.getClassLoader());
            List mutableList = readParcelableArray != null ? ArraysKt___ArraysKt.toMutableList(readParcelableArray) : null;
            mutableList = TypeIntrinsics.isMutableList(mutableList) ? mutableList : null;
            if (mutableList != null) {
                this.props.addAll(mutableList);
            }
        }
        if (parcel.readInt() == 1) {
            Parcelable[] readParcelableArray2 = parcel.readParcelableArray(KRTurboDisplayNode.class.getClassLoader());
            List mutableList2 = readParcelableArray2 != null ? ArraysKt___ArraysKt.toMutableList(readParcelableArray2) : null;
            mutableList2 = TypeIntrinsics.isMutableList(mutableList2) ? mutableList2 : null;
            if (mutableList2 != null) {
                this.callMethods.addAll(mutableList2);
            }
        }
        if (parcel.readInt() == 1) {
            Parcelable[] readParcelableArray3 = parcel.readParcelableArray(KRTurboDisplayNode.class.getClassLoader());
            List mutableList3 = readParcelableArray3 != null ? ArraysKt___ArraysKt.toMutableList(readParcelableArray3) : null;
            List list = TypeIntrinsics.isMutableList(mutableList3) ? mutableList3 : null;
            if (list != null) {
                this.children.addAll(list);
            }
        }
    }
}
