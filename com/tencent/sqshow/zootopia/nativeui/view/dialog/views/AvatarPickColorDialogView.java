package com.tencent.sqshow.zootopia.nativeui.view.dialog.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.action.ColorPanelTopOptView;
import com.tencent.sqshow.zootopia.nativeui.view.color.ColorPickerPanelView;
import k94.ColorPanelData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m94.DressHistoryChangeInfo;
import n74.y;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001\u001bB7\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00103\u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020$\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/AvatarPickColorDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/BaseSubPanelDialogView;", "", "W", "X", "Ln74/y;", "binding", "c0", "b0", "", "index", "Lqu4/d;", "targetColorSlotInfo", "e0", "f0", "itemIndex", "d0", "Z", "a0", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "w", "onDismiss", "", UserInfo.SEX_FEMALE, "P", "a", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "D", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", WadlProxyConsts.CHANNEL, "Lk94/b;", "E", "Lk94/b;", "mColorPanelData", "Lqu4/d;", "colorSlotInfo", "G", "Ln74/y;", "mBinding", "H", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;Lk94/b;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarPickColorDialogView extends BaseSubPanelDialogView {

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: E, reason: from kotlin metadata */
    private final ColorPanelData mColorPanelData;

    /* renamed from: F, reason: from kotlin metadata */
    private qu4.d colorSlotInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private y mBinding;

    /* renamed from: H, reason: from kotlin metadata */
    private int itemIndex;

    public /* synthetic */ AvatarPickColorDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, ColorPanelData colorPanelData, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar, colorPanelData);
    }

    private final void W() {
        LinearLayout root;
        y yVar = this.mBinding;
        if (yVar == null || (root = yVar.getRoot()) == null) {
            return;
        }
        this.channel.getReporter().a(root, "pg_zplan_avatar_dye");
    }

    private final void X() {
        this.channel.getAvatarColorController().a(this.mColorPanelData.getColorInfo());
        this.colorSlotInfo = da4.b.f393480a.e(this.mColorPanelData.getColorInfo(), this.mColorPanelData.getSlotId());
        LifecycleOwner lifecycleOwner = this.channel.getLifecycleOwner();
        if (lifecycleOwner != null) {
            MutableLiveData<DressHistoryChangeInfo> q16 = this.channel.q();
            final Function1<DressHistoryChangeInfo, Unit> function1 = new Function1<DressHistoryChangeInfo, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.AvatarPickColorDialogView$initData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DressHistoryChangeInfo dressHistoryChangeInfo) {
                    invoke2(dressHistoryChangeInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DressHistoryChangeInfo dressHistoryChangeInfo) {
                    ColorPanelData colorPanelData;
                    ColorPanelData colorPanelData2;
                    y yVar;
                    FrameLayout frameLayout;
                    int historyCursor = dressHistoryChangeInfo.getData().getHistoryCursor();
                    if (dressHistoryChangeInfo.getOperation() == 1) {
                        QLog.i("AvatarPickColorDialogView", 1, "dressHistoryData cursor == " + historyCursor);
                        m94.a g16 = dressHistoryChangeInfo.getData().g(historyCursor);
                        da4.b bVar = da4.b.f393480a;
                        qu4.c cVar = g16.getAvatarCharacter().f429575d;
                        Intrinsics.checkNotNullExpressionValue(cVar, "dressData.avatarCharacter.colorInfo");
                        colorPanelData = AvatarPickColorDialogView.this.mColorPanelData;
                        qu4.d e16 = bVar.e(cVar, colorPanelData.getSlotId());
                        colorPanelData2 = AvatarPickColorDialogView.this.mColorPanelData;
                        if (colorPanelData2.getColorConfig().f440219b != 2) {
                            AvatarPickColorDialogView.this.e0(0, e16);
                            return;
                        }
                        int i3 = e16 != null ? e16.f429584b : 0;
                        AvatarPickColorDialogView.this.f0(i3);
                        yVar = AvatarPickColorDialogView.this.mBinding;
                        if (yVar == null || (frameLayout = yVar.f419471d) == null) {
                            return;
                        }
                        AvatarPickColorDialogView avatarPickColorDialogView = AvatarPickColorDialogView.this;
                        if (i3 < frameLayout.getChildCount()) {
                            avatarPickColorDialogView.e0(i3, e16);
                        }
                    }
                }
            };
            q16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AvatarPickColorDialogView.Y(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Z(y binding) {
        QLog.i("AvatarPickColorDialogView", 1, "initPanel :: colorConfigType == " + this.mColorPanelData.getColorConfig().f440219b);
        int i3 = this.mColorPanelData.getColorConfig().f440219b;
        if (i3 == 1) {
            binding.f419471d.addView(new ColorPickerPanelView(getContext(), 0, this.mColorPanelData, this.channel), new FrameLayout.LayoutParams(-1, -2));
            return;
        }
        if (i3 == 2) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            binding.f419471d.addView(new ColorPickerPanelView(getContext(), 0, this.mColorPanelData, this.channel), layoutParams);
            ColorPickerPanelView colorPickerPanelView = new ColorPickerPanelView(getContext(), 1, this.mColorPanelData, this.channel);
            colorPickerPanelView.setVisibility(8);
            binding.f419471d.addView(colorPickerPanelView, layoutParams);
            return;
        }
        if (i3 == 3) {
            binding.f419471d.addView(new ColorPickerPanelView(getContext(), 2, this.mColorPanelData, this.channel), new FrameLayout.LayoutParams(-1, -2));
        } else {
            if (i3 != 4) {
                return;
            }
            binding.f419471d.addView(new ColorPickerPanelView(getContext(), 3, this.mColorPanelData, this.channel), new FrameLayout.LayoutParams(-1, -2));
        }
    }

    private final void a0(y binding) {
        binding.f419472e.g(this.channel);
        binding.f419472e.setColorPanelData(this.mColorPanelData);
    }

    private final void b0(y binding) {
        if (this.mColorPanelData.getColorConfig().f440219b == 4 || this.mColorPanelData.getColorConfig().f440219b == 3) {
            binding.f419470c.setVisibility(8);
            binding.f419469b.setVisibility(8);
        }
        int f16 = da4.b.f393480a.f(this.colorSlotInfo, this.mColorPanelData.getPanelIndex());
        this.itemIndex = f16;
        QLog.i("AvatarPickColorDialogView", 4, "itemIndex == " + f16);
        d0(this.itemIndex, binding);
        binding.f419470c.setChannel(this.channel);
        binding.f419470c.setShowType(this.mColorPanelData.getColorConfig().f440219b, this.itemIndex);
        binding.f419470c.setOnTabSelectedListener(new Function1<Integer, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.AvatarPickColorDialogView$initTitle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                QLog.i("AvatarPickColorDialogView", 1, "select item == " + i3);
                AvatarPickColorDialogView.this.itemIndex = i3;
                AvatarPickColorDialogView.this.f0(i3);
            }
        });
    }

    private final void c0(y binding) {
        b0(binding);
        a0(binding);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(int index, qu4.d targetColorSlotInfo) {
        FrameLayout frameLayout;
        y yVar = this.mBinding;
        View childAt = (yVar == null || (frameLayout = yVar.f419471d) == null) ? null : frameLayout.getChildAt(index);
        if (childAt == null || targetColorSlotInfo == null) {
            return;
        }
        ColorPickerPanelView.x((ColorPickerPanelView) childAt, targetColorSlotInfo, null, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(int index) {
        y yVar = this.mBinding;
        if (yVar != null) {
            if (index < yVar.f419471d.getChildCount()) {
                int childCount = yVar.f419471d.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    yVar.f419471d.getChildAt(i3).setVisibility(8);
                }
                yVar.f419471d.getChildAt(index).setVisibility(0);
            }
            d0(index, yVar);
            yVar.f419470c.h(index);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected boolean F() {
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView
    public int P() {
        return 2;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public boolean a() {
        getMChannel().getAvatarColorController().c(getMChannel());
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        y g16 = y.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.mBinding = g16;
        X();
        c0(g16);
        Z(g16);
        f0(this.itemIndex);
        W();
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView, com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void onDismiss() {
        ColorPanelTopOptView colorPanelTopOptView;
        super.onDismiss();
        y yVar = this.mBinding;
        if (yVar == null || (colorPanelTopOptView = yVar.f419472e) == null) {
            return;
        }
        colorPanelTopOptView.j();
    }

    public final void setChannel(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.channel = jVar;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public Object w() {
        y yVar = this.mBinding;
        if (yVar != null) {
            return yVar.getRoot();
        }
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPickColorDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel, ColorPanelData mColorPanelData) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(mColorPanelData, "mColorPanelData");
        this.channel = channel;
        this.mColorPanelData = mColorPanelData;
    }

    private final void d0(int itemIndex, y binding) {
        if (itemIndex == 1) {
            binding.f419472e.n();
        } else {
            binding.f419472e.k();
        }
    }
}
