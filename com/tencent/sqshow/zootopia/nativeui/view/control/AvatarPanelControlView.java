package com.tencent.sqshow.zootopia.nativeui.view.control;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b94.e;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.view.AvatarPanelViewData;
import com.tencent.sqshow.zootopia.nativeui.view.control.AvatarPanelControlView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;
import g94.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.q;
import tl.h;
import y94.a;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 A2\u00020\u0001:\u0002BCB'\b\u0007\u0012\u0006\u0010;\u001a\u00020:\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010>\u001a\u00020\u0007\u00a2\u0006\u0004\b?\u0010@J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J,\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J(\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eJ2\u0010\u001c\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u0019R\u0016\u0010\u001e\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010&R$\u0010,\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010+R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00030-j\b\u0012\u0004\u0012\u00020\u0003`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000b0-j\b\u0012\u0004\u0012\u00020\u000b`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0018\u00106\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006D"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/control/AvatarPanelControlView;", "Landroid/widget/FrameLayout;", "", "Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "data", "", h.F, "", "position", "type", "lastType", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/AvatarPanelControlView$b;", "d", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "f", "g", "c", "from", "i", "selectedIndex", "setSelectIndex", "defaultIndex", "", "isFromChangeGender", "isFakeData", "setData", "Ljava/lang/String;", "mSelectedIndex", "e", "I", "mSelectedPosition", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Ln74/q;", "Ln74/q;", "mBinding", "Ljava/util/HashSet;", "Lb94/b;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mListenerPool", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mDataList", BdhLogUtil.LogTag.Tag_Conn, "mViewList", "D", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/AvatarPanelControlView$b;", "currentViewHolder", "E", "Z", "isViewShow", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class AvatarPanelControlView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final ArrayList<b> mViewList;

    /* renamed from: D, reason: from kotlin metadata */
    private b currentViewHolder;

    /* renamed from: E, reason: from kotlin metadata */
    private volatile boolean isViewShow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mSelectedIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mSelectedPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private j channel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final q mBinding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final HashSet<b94.b> mListenerPool;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<AvatarPanelViewData> mDataList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarPanelControlView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(int position, AvatarPanelViewData data, int type, int lastType) {
        a reporter;
        ZplanViewReportHelper mReporter;
        b d16 = d(position, data, type, lastType);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getContext().getResources().getDimension(R.dimen.f11093u), (int) getContext().getResources().getDimension(R.dimen.f11033o));
        layoutParams.gravity = 1;
        this.mBinding.f419398b.addView(d16.getRootView(), layoutParams);
        this.mViewList.add(d16);
        j jVar = this.channel;
        if (jVar == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        mReporter.g(d16.getRootView(), "em_zplan_mall_btn", (r16 & 4) != 0 ? null : f(data), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final b d(final int position, final AvatarPanelViewData data, int type, int lastType) {
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.d_b, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        final b bVar = new b(position, itemView, data, type, lastType);
        aa.e(bVar.getRootView(), new View.OnClickListener() { // from class: ea4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarPanelControlView.e(AvatarPanelViewData.this, this, bVar, position, view);
            }
        }, 100L);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AvatarPanelViewData data, AvatarPanelControlView this$0, b itemViewHolder, int i3, View view) {
        a reporter;
        ZplanViewReportHelper mReporter;
        e O;
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemViewHolder, "$itemViewHolder");
        if (data.getFakeData()) {
            return;
        }
        j jVar = this$0.channel;
        if (!((jVar == null || (O = jVar.O()) == null) ? false : O.getMPanelHasEnter())) {
            QLog.e("AvatarPanelControlView_", 1, "panelHasEnter==false, no click can happened!");
            return;
        }
        j jVar2 = this$0.channel;
        if (jVar2 != null && (reporter = jVar2.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            mReporter.e(itemViewHolder.getRootView(), "em_zplan_mall_btn", this$0.f(data));
        }
        String index = data.getIndex();
        this$0.mSelectedIndex = index;
        this$0.mSelectedPosition = i3;
        QLog.i("AvatarPanelControlView_", 1, "item click controlType:" + index + ", mSelectedPosition:" + i3);
        this$0.i("click");
        Iterator<T> it = this$0.mListenerPool.iterator();
        while (it.hasNext()) {
            ((b94.b) it.next()).T(this$0.mSelectedIndex);
        }
    }

    private final HashMap<String, Object> f(AvatarPanelViewData data) {
        Object obj;
        HashMap<String, Object> hashMap = new HashMap<>();
        int i3 = data.getCategoryGroup().f440212h;
        gv4.e m3 = ZPlanRedDotManager.m(ZPlanRedDotManager.f373437a, i3, 0, 2, null);
        hashMap.put("zplan_mall_type", Integer.valueOf(data.getCategoryGroup().f440206b));
        hashMap.put("zplan_redpoint_id", Integer.valueOf(i3));
        if (m3 != null) {
            obj = Integer.valueOf(m3.f403426b);
        } else {
            obj = "";
        }
        hashMap.put("zplan_redpoint_type", obj);
        return hashMap;
    }

    private final void g() {
        int i3;
        this.mViewList.clear();
        this.mBinding.f419398b.removeAllViews();
        int size = this.mDataList.size();
        if (size <= 0) {
            return;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            if (i17 == 0) {
                AvatarPanelViewData avatarPanelViewData = this.mDataList.get(i17);
                Intrinsics.checkNotNullExpressionValue(avatarPanelViewData, "mDataList[i]");
                i3 = 1;
                c(i17, avatarPanelViewData, 1, i16);
            } else if (i17 == size - 1) {
                AvatarPanelViewData avatarPanelViewData2 = this.mDataList.get(i17);
                Intrinsics.checkNotNullExpressionValue(avatarPanelViewData2, "mDataList[i]");
                i3 = 3;
                c(i17, avatarPanelViewData2, 3, i16);
            } else {
                AvatarPanelViewData avatarPanelViewData3 = this.mDataList.get(i17);
                Intrinsics.checkNotNullExpressionValue(avatarPanelViewData3, "mDataList[i]");
                i3 = 2;
                c(i17, avatarPanelViewData3, 2, i16);
            }
            i16 = i3;
        }
    }

    private final void h(List<AvatarPanelViewData> data) {
        for (AvatarPanelViewData avatarPanelViewData : data) {
            String icon = avatarPanelViewData.getCategoryGroup().f440208d;
            if (icon != null) {
                Intrinsics.checkNotNullExpressionValue(icon, "icon");
                CommonExKt.o(icon, null, null, 3, null);
            }
            String activeIcon = avatarPanelViewData.getCategoryGroup().f440209e;
            if (activeIcon != null) {
                Intrinsics.checkNotNullExpressionValue(activeIcon, "activeIcon");
                CommonExKt.o(activeIcon, null, null, 3, null);
            }
        }
    }

    private final void i(String from) {
        int i3 = 0;
        for (Object obj : this.mViewList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual(bVar.getData().getIndex(), this.mSelectedIndex)) {
                this.currentViewHolder = bVar;
            }
            int position = bVar.getPosition();
            bVar.i(this.mSelectedIndex, from, this);
            if (bVar.getType() != 1 && bVar.getType() != 3) {
                if (position == this.mSelectedPosition) {
                    b.h(bVar, false, false, 3, null);
                }
                if (position > this.mSelectedPosition) {
                    bVar.g(true, false);
                }
                if (position < this.mSelectedPosition) {
                    bVar.g(false, true);
                }
                if (this.mSelectedPosition < 0 && position == 1) {
                    bVar.g(false, false);
                }
            } else {
                b.h(bVar, false, false, 3, null);
            }
            i3 = i16;
        }
    }

    public final void setData(List<AvatarPanelViewData> data, String defaultIndex, boolean isFromChangeGender, boolean isFakeData) {
        Object obj;
        Object obj2;
        int indexOf;
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(defaultIndex, "defaultIndex");
        h(data);
        Iterator<T> it = data.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it.next();
                if (Intrinsics.areEqual(((AvatarPanelViewData) obj2).getIndex(), defaultIndex)) {
                    break;
                }
            }
        }
        this.mSelectedIndex = obj2 != null ? defaultIndex : "";
        Iterator<T> it5 = this.mDataList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (Intrinsics.areEqual(((AvatarPanelViewData) next).getIndex(), defaultIndex)) {
                obj = next;
                break;
            }
        }
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends AvatarPanelViewData>) ((List<? extends Object>) this.mDataList), (AvatarPanelViewData) obj);
        this.mSelectedPosition = indexOf;
        QLog.i("AvatarPanelControlView_", 1, "setData controlType:" + this.mSelectedIndex + ", mSelectedPosition:" + indexOf + ", isFromChangeGender: " + isFromChangeGender);
        this.mDataList.clear();
        this.mDataList.addAll(data);
        g();
        if (isFromChangeGender) {
            str = "changeGender";
        } else {
            str = "setData";
        }
        if (isFakeData) {
            str = "fakeData";
        }
        i(str);
        if (Intrinsics.areEqual(this.mSelectedIndex, "")) {
            return;
        }
        Iterator<T> it6 = this.mListenerPool.iterator();
        while (it6.hasNext()) {
            ((b94.b) it6.next()).T(this.mSelectedIndex);
        }
    }

    public final void setSelectIndex(String selectedIndex, String from) {
        Object obj;
        int indexOf;
        Intrinsics.checkNotNullParameter(selectedIndex, "selectedIndex");
        Intrinsics.checkNotNullParameter(from, "from");
        this.mSelectedIndex = selectedIndex;
        Iterator<T> it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((AvatarPanelViewData) obj).getIndex(), this.mSelectedIndex)) {
                    break;
                }
            }
        }
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends AvatarPanelViewData>) ((List<? extends Object>) this.mDataList), (AvatarPanelViewData) obj);
        this.mSelectedPosition = indexOf;
        QLog.i("AvatarPanelControlView_", 1, "setSelectType controlType:" + selectedIndex + ", mSelectedPosition:" + indexOf);
        i(from);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarPanelControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AvatarPanelControlView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPanelControlView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSelectedIndex = "";
        this.mSelectedPosition = -1;
        q f16 = q.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mListenerPool = new HashSet<>();
        this.mDataList = new ArrayList<>();
        this.mViewList = new ArrayList<>();
        setClipChildren(false);
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 K2\u00020\u0001:\u0001\u0012B/\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\bI\u0010JJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u0018\u0010\u001fR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b!\u0010\u0015R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b#\u0010\u0015R\u001c\u0010(\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010'R\u001c\u0010+\u001a\n &*\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010*R\u001c\u0010/\u001a\n &*\u0004\u0018\u00010,0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00102\u001a\n &*\u0004\u0018\u000100008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00101R\u001c\u00104\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010'R\u001c\u00106\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010'R\u0018\u00109\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\"\u0010C\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u0013\u001a\u0004\bE\u0010\u0015\"\u0004\bF\u0010G\u00a8\u0006L"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/control/AvatarPanelControlView$b;", "", "", "id", "", "selected", "", "currentIndex", "", "f", "topHide", "bottomHide", "g", "selectedIndex", "from", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/AvatarPanelControlView;", HippyNestedScrollComponent.PRIORITY_PARENT, "i", "a", "I", "c", "()I", "position", "Landroid/view/View;", "b", "Landroid/view/View;", "d", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "()Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "data", "e", "type", "getTopType", MiniChatConstants.MINI_APP_TOP_TYPE, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Landroid/widget/ImageView;", "bgView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "hintTxv", "Lcom/tencent/image/URLImageView;", h.F, "Lcom/tencent/image/URLImageView;", "iconIgv", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "Lcom/tencent/sqshow/zootopia/widget/reddot/ZPlanRedDotView;", "redDot", "j", "topSplitLine", "k", "bottomSplitLine", "l", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/AvatarPanelControlView;", "parentView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "currentSelectedIndex", DomainData.DOMAIN_NAME, "Z", "getClearAfterNotSelected", "()Z", "setClearAfterNotSelected", "(Z)V", "clearAfterNotSelected", "o", "getRedDotId", "setRedDotId", "(I)V", "redDotId", "<init>", "(ILandroid/view/View;Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;II)V", "p", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int position;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final View rootView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final AvatarPanelViewData data;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int topType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final ImageView bgView;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final TextView hintTxv;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final URLImageView iconIgv;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final ZPlanRedDotView redDot;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private final ImageView topSplitLine;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private final ImageView bottomSplitLine;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private AvatarPanelControlView parentView;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private String currentSelectedIndex;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private boolean clearAfterNotSelected;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private int redDotId;

        public b(int i3, View rootView, AvatarPanelViewData data, int i16, int i17) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(data, "data");
            this.position = i3;
            this.rootView = rootView;
            this.data = data;
            this.type = i16;
            this.topType = i17;
            this.bgView = (ImageView) rootView.findViewById(R.id.pmi);
            this.hintTxv = (TextView) rootView.findViewById(R.id.pml);
            this.iconIgv = (URLImageView) rootView.findViewById(R.id.pmj);
            this.redDot = (ZPlanRedDotView) rootView.findViewById(R.id.qgv);
            this.topSplitLine = (ImageView) rootView.findViewById(R.id.q36);
            this.bottomSplitLine = (ImageView) rootView.findViewById(R.id.q2t);
            this.currentSelectedIndex = "";
            this.redDotId = -1;
        }

        private final void f(int id5, boolean selected, String currentIndex) {
            this.redDotId = id5;
            this.redDot.g(1);
            this.redDot.h(id5);
            this.currentSelectedIndex = currentIndex;
            if (selected || !this.clearAfterNotSelected) {
                return;
            }
            AvatarPanelControlView avatarPanelControlView = this.parentView;
            if (avatarPanelControlView != null && avatarPanelControlView.isViewShow) {
                QLog.d("AvatarPanelControlView_", 1, "clear redDot, id: " + this.redDotId + ", when not selected");
                a(id5);
                this.clearAfterNotSelected = false;
            }
        }

        public final void a(int id5) {
            f.b(f.f401577a, id5, this.redDot.getStoreType(), 0, false, 12, null);
        }

        /* renamed from: b, reason: from getter */
        public final AvatarPanelViewData getData() {
            return this.data;
        }

        /* renamed from: c, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* renamed from: d, reason: from getter */
        public final View getRootView() {
            return this.rootView;
        }

        /* renamed from: e, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final void g(boolean topHide, boolean bottomHide) {
            if (topHide) {
                this.topSplitLine.setVisibility(8);
            } else {
                this.topSplitLine.setVisibility(0);
            }
            if (bottomHide) {
                this.bottomSplitLine.setVisibility(8);
            } else {
                this.bottomSplitLine.setVisibility(0);
            }
        }

        public final void i(String selectedIndex, String from, AvatarPanelControlView parent) {
            Intrinsics.checkNotNullParameter(selectedIndex, "selectedIndex");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(parent, "parent");
            this.parentView = parent;
            boolean areEqual = Intrinsics.areEqual(selectedIndex, this.data.getIndex());
            TextView textView = this.hintTxv;
            String str = this.data.getCategoryGroup().f440207c;
            if (str.length() == 0) {
                str = this.data.getDefaultName();
            }
            textView.setText(str);
            f(this.data.getCategoryGroup().f440212h, areEqual, this.data.getIndex());
            ViewGroup.LayoutParams layoutParams = this.rootView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            int dimension = (int) this.rootView.getContext().getResources().getDimension(R.dimen.f11063r);
            int dimension2 = (int) this.rootView.getContext().getResources().getDimension(R.dimen.f11073s);
            int dimension3 = (int) this.rootView.getContext().getResources().getDimension(R.dimen.f11083t);
            int dimension4 = (int) this.rootView.getContext().getResources().getDimension(R.dimen.f11043p);
            int dimension5 = (int) this.rootView.getContext().getResources().getDimension(R.dimen.f11053q);
            if (areEqual) {
                if (Intrinsics.areEqual(from, "click")) {
                    a(this.data.getCategoryGroup().f440212h);
                }
                int hashCode = from.hashCode();
                if (hashCode == -449810799 ? from.equals("changeGender") : hashCode == 3273774 ? from.equals("jump") : !(hashCode != 1984503596 || !from.equals("setData"))) {
                    this.clearAfterNotSelected = true;
                }
                URLImageView iconIgv = this.iconIgv;
                Intrinsics.checkNotNullExpressionValue(iconIgv, "iconIgv");
                String str2 = this.data.getCategoryGroup().f440209e;
                Intrinsics.checkNotNullExpressionValue(str2, "data.categoryGroup.activeIcon");
                CommonExKt.w(iconIgv, str2, com.tencent.sqshow.zootopia.utils.q.b(R.drawable.h4a), null, 4, null);
                this.hintTxv.setTextColor(-1);
                int i3 = this.type;
                if (i3 == 1) {
                    this.bgView.setImageResource(R.drawable.iew);
                    layoutParams2.rightMargin = dimension;
                    layoutParams2.bottomMargin = dimension;
                } else if (i3 == 2) {
                    this.bgView.setImageResource(R.drawable.ieu);
                    if (this.topType != 1) {
                        dimension3 = dimension5;
                    }
                    layoutParams2.topMargin = dimension3;
                    layoutParams2.rightMargin = dimension;
                    layoutParams2.bottomMargin = dimension;
                } else if (i3 == 3) {
                    this.bgView.setImageResource(R.drawable.ies);
                    layoutParams2.topMargin = dimension3;
                    layoutParams2.rightMargin = dimension;
                }
                this.rootView.setLayoutParams(layoutParams2);
                return;
            }
            if (this.data.getFakeData()) {
                this.iconIgv.setImageResource(this.data.getDefaultResId());
                this.iconIgv.setAlpha(0.7f);
                this.hintTxv.setTextColor(Color.parseColor("#FFC7CCD1"));
            } else {
                URLImageView iconIgv2 = this.iconIgv;
                Intrinsics.checkNotNullExpressionValue(iconIgv2, "iconIgv");
                String str3 = this.data.getCategoryGroup().f440208d;
                Intrinsics.checkNotNullExpressionValue(str3, "data.categoryGroup.icon");
                CommonExKt.w(iconIgv2, str3, com.tencent.sqshow.zootopia.utils.q.b(R.drawable.h4a), null, 4, null);
                this.hintTxv.setTextColor(Color.parseColor("#FF2C3951"));
            }
            int i16 = this.type;
            if (i16 == 1) {
                this.bgView.setImageResource(R.drawable.iev);
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
            } else if (i16 == 2) {
                this.bgView.setImageResource(R.drawable.iet);
                if (this.topType != 1) {
                    dimension2 = dimension4;
                }
                layoutParams2.topMargin = dimension2;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
            } else if (i16 == 3) {
                this.bgView.setImageResource(R.drawable.ier);
                layoutParams2.topMargin = dimension2;
                layoutParams2.rightMargin = 0;
            }
            this.rootView.setLayoutParams(layoutParams2);
        }

        public static /* synthetic */ void h(b bVar, boolean z16, boolean z17, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            if ((i3 & 2) != 0) {
                z17 = true;
            }
            bVar.g(z16, z17);
        }
    }

    public static /* synthetic */ void setData$default(AvatarPanelControlView avatarPanelControlView, List list, String str, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str = "";
            }
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            if ((i3 & 8) != 0) {
                z17 = false;
            }
            avatarPanelControlView.setData(list, str, z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setData");
    }
}
