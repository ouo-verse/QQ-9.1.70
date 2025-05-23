package com.tencent.mobileqq.zplan.minihome.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.utils.l;
import com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import fi3.bn;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=BW\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020#\u0012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070'\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010,R.\u00105\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00058\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R!\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b6\u00107*\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/h;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/minihome/view/h$a;", "Lfi3/bn;", "binding", "", "position", "", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "m0", "getItemCount", "holder", "l0", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "scene", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lr55/b;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/MutableStateFlow;", "source", "Landroid/view/View;", "D", "Landroid/view/View;", "chosenMarkView", "E", "I", "thumbnailWidth", UserInfo.SEX_FEMALE, "thumbnailHeight", "Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeSampleType;", "G", "Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeSampleType;", "type", "Lkotlin/Function1;", "H", "Lkotlin/jvm/functions/Function1;", "onChoose", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "value", "J", "Ljava/lang/Integer;", "j0", "()Ljava/lang/Integer;", "p0", "(Ljava/lang/Integer;)V", "choosing", "k0", "()[Lr55/b;", "getData$delegate", "(Lcom/tencent/mobileqq/zplan/minihome/view/h;)Ljava/lang/Object;", "data", "<init>", "(Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;Lkotlinx/coroutines/flow/MutableStateFlow;Landroid/view/View;IILcom/tencent/mobileqq/zplan/minihome/view/MiniHomeSampleType;Lkotlin/jvm/functions/Function1;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableStateFlow<r55.b[]> source;

    /* renamed from: D, reason: from kotlin metadata */
    private final View chosenMarkView;

    /* renamed from: E, reason: from kotlin metadata */
    private final int thumbnailWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private final int thumbnailHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private final MiniHomeSampleType type;

    /* renamed from: H, reason: from kotlin metadata */
    private final Function1<r55.b, Unit> onChoose;

    /* renamed from: I, reason: from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    /* renamed from: J, reason: from kotlin metadata */
    private Integer choosing;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeSceneEnum scene;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/h$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lfi3/bn;", "E", "Lfi3/bn;", "l", "()Lfi3/bn;", "binding", "<init>", "(Lfi3/bn;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final bn binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bn binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            View view = this.itemView;
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            int a16 = com.tencent.sqshow.zootopia.utils.i.a(17.5f);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = a16;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a16;
            view.setLayoutParams(layoutParams);
        }

        /* renamed from: l, reason: from getter */
        public final bn getBinding() {
            return this.binding;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(MiniHomeSceneEnum scene, MutableStateFlow<r55.b[]> source, View chosenMarkView, int i3, int i16, MiniHomeSampleType type, Function1<? super r55.b, Unit> onChoose) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(chosenMarkView, "chosenMarkView");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onChoose, "onChoose");
        this.scene = scene;
        this.source = source;
        this.chosenMarkView = chosenMarkView;
        this.thumbnailWidth = i3;
        this.thumbnailHeight = i16;
        this.type = type;
        this.onChoose = onChoose;
        this.reportHelper = new ZplanViewReportHelper();
    }

    private final r55.b[] k0() {
        return this.source.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(h this$0, a this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Integer num = this$0.choosing;
        int adapterPosition = this_apply.getAdapterPosition();
        this$0.p0(Integer.valueOf(adapterPosition));
        this$0.notifyItemChanged(adapterPosition);
        if (num != null) {
            this$0.notifyItemChanged(num.intValue());
        }
        this$0.o0(this_apply.getBinding(), adapterPosition);
    }

    private final void o0(bn binding, int position) {
        MiniHomeSceneEnum miniHomeSceneEnum = this.scene;
        if (miniHomeSceneEnum == MiniHomeSceneEnum.SCENE_CREATE) {
            VideoReport.setElementId(binding.getRoot(), "em_zplan_sample_room_pic");
            VideoReport.setElementExposePolicy(binding.getRoot(), ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(binding.getRoot(), ClickPolicy.REPORT_ALL);
            VideoReport.reportEvent("clck", binding.getRoot(), null);
            return;
        }
        if (miniHomeSceneEnum != MiniHomeSceneEnum.SCENE_EDIT || position >= getItemCount()) {
            return;
        }
        r55.b bVar = k0()[position];
        if (bVar.f430785h != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_item_price", Integer.valueOf(bVar.f430791n));
            String str = bVar.f430785h.f430773a;
            Intrinsics.checkNotNullExpressionValue(str, "item.roomDesc.hash");
            linkedHashMap.put("zplan_model_room_id", str);
            VideoReport.reportEvent("clck", binding.getRoot(), linkedHashMap);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return k0().length;
    }

    /* renamed from: j0, reason: from getter */
    public final Integer getChoosing() {
        return this.choosing;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003a  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(a holder, int position) {
        boolean z16;
        boolean isBlank;
        Integer num;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        r55.b bVar = k0()[position];
        bn binding = holder.getBinding();
        binding.f399128d.setText(bVar.f430778a);
        Drawable drawable = AppCompatResources.getDrawable(binding.getRoot().getContext(), R.drawable.il5);
        ImageView imageView = binding.f399130f;
        String str = bVar.f430780c;
        boolean z17 = true;
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    String str2 = bVar.f430780c;
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    Unit unit = Unit.INSTANCE;
                    drawable = URLDrawable.getDrawable(str2, obtain);
                }
                imageView.setBackground(drawable);
                if (this.type != MiniHomeSampleType.CHOOSE) {
                    RecyclerView recyclerView = binding.f399129e;
                    String[] strArr = bVar.f430782e;
                    Intrinsics.checkNotNullExpressionValue(strArr, "item.tagImageUrls");
                    recyclerView.setAdapter(new i(strArr));
                    binding.f399127c.setVisibility(8);
                    binding.f399126b.setVisibility(8);
                } else {
                    binding.f399129e.setVisibility(8);
                    if (bVar.f430781d) {
                        String str3 = bVar.f430779b;
                        if (str3 != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                            if (!isBlank) {
                                z17 = false;
                            }
                        }
                        if (!z17) {
                            binding.f399127c.setText(bVar.f430779b);
                            binding.f399127c.setVisibility(0);
                            binding.f399126b.setVisibility(0);
                            binding.f399126b.setIsOwned(bVar.f430787j);
                            binding.f399126b.setPrice(bVar.f430791n, bVar.f430792o);
                        }
                    }
                    binding.f399127c.setVisibility(8);
                    binding.f399126b.setVisibility(0);
                    binding.f399126b.setIsOwned(bVar.f430787j);
                    binding.f399126b.setPrice(bVar.f430791n, bVar.f430792o);
                }
                num = this.choosing;
                if (num != null && num.intValue() == position) {
                    l.b(this.chosenMarkView);
                    binding.f399131g.addView(this.chosenMarkView);
                    if (this.scene == MiniHomeSceneEnum.SCENE_CREATE) {
                        binding.f399128d.setTextColor(binding.getRoot().getContext().getResources().getColor(R.color.qui_common_feedback_normal));
                    }
                } else {
                    if (this.scene == MiniHomeSceneEnum.SCENE_CREATE) {
                        binding.f399128d.setTextColor(binding.getRoot().getContext().getResources().getColor(R.color.qui_common_text_primary));
                    }
                    binding.f399131g.removeView(this.chosenMarkView);
                }
                if (bVar.f430796s) {
                    binding.f399126b.setVisibility(8);
                }
                if (this.scene != MiniHomeSceneEnum.SCENE_EDIT || bVar.f430785h == null) {
                    return;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("zplan_item_price", Integer.valueOf(bVar.f430791n));
                String str4 = bVar.f430785h.f430773a;
                Intrinsics.checkNotNullExpressionValue(str4, "item.roomDesc.hash");
                linkedHashMap.put("zplan_model_room_id", str4);
                VideoReport.setElementId(holder.getBinding().getRoot(), "em_zplan_model_room_item");
                VideoReport.setElementExposePolicy(holder.getBinding().getRoot(), ExposurePolicy.REPORT_FIRST);
                VideoReport.setElementClickPolicy(holder.getBinding().getRoot(), ClickPolicy.REPORT_NONE);
                VideoReport.setElementParams(holder.getBinding().getRoot(), linkedHashMap);
                VideoReport.setElementReuseIdentifier(holder.getBinding().getRoot(), bVar.f430785h.f430773a + "_" + position);
                VideoReport.traverseExposure();
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
        imageView.setBackground(drawable);
        if (this.type != MiniHomeSampleType.CHOOSE) {
        }
        num = this.choosing;
        if (num != null) {
            l.b(this.chosenMarkView);
            binding.f399131g.addView(this.chosenMarkView);
            if (this.scene == MiniHomeSceneEnum.SCENE_CREATE) {
            }
            if (bVar.f430796s) {
            }
            if (this.scene != MiniHomeSceneEnum.SCENE_EDIT) {
                return;
            } else {
                return;
            }
        }
        if (this.scene == MiniHomeSceneEnum.SCENE_CREATE) {
        }
        binding.f399131g.removeView(this.chosenMarkView);
        if (bVar.f430796s) {
        }
        if (this.scene != MiniHomeSceneEnum.SCENE_EDIT) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bn g16 = bn.g(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(parent.context))");
        final a aVar = new a(g16);
        RecyclerView recyclerView = aVar.getBinding().f399129e;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(parent.getContext());
        flexboxLayoutManager.b0(2);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        aVar.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.n0(h.this, aVar, view);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.thumbnailWidth, this.thumbnailHeight);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        aVar.getBinding().f399131g.setLayoutParams(layoutParams);
        return aVar;
    }

    public final void p0(Integer num) {
        this.choosing = num;
        if (num == null || num.intValue() >= k0().length) {
            return;
        }
        this.onChoose.invoke(k0()[num.intValue()]);
    }
}
