package com.tencent.mobileqq.wink.editor.music.lyric.sticker;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.view.WinkDownLoadingView;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020\u001e\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0018\u0010\u000b\u001a\u00020\u00062\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\tJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\"\u0010\u0014\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J*\u0010\u001d\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerAdapter;", "Lcom/tencent/mobileqq/wink/view/ab;", "Landroid/view/View;", "v", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "s0", "v0", "", "data", "u0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/wink/view/ab$a;", "o0", "vh", "position", "n0", "", "materialID", "t0", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "holder", "", "", "payloads", "onBindViewHolder", "Landroid/content/Context;", "T", "Landroid/content/Context;", "mContext", "Lkotlin/Function0;", "U", "Lkotlin/jvm/functions/Function0;", "setDefaultLyricStickerBlock", "context", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorLyricStickerAdapter extends ab {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> setDefaultLyricStickerBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorLyricStickerAdapter(@NotNull Context context, @Nullable WinkEditorViewModel.EditMode editMode) {
        super(context, editMode);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
    }

    private final void s0(View v3, MetaMaterial material) {
        VideoReport.setElementId(v3, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRICS_ITEM);
        VideoReport.setElementReuseIdentifier(v3, String.valueOf(material.hashCode()));
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_BUTTON_LOCATION, WinkEditorLyricStickerMenuPart.INSTANCE.a());
        Map<String, String> map = material.additionalFields;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (map.containsKey("name")) {
                Map<String, String> map2 = material.additionalFields;
                Intrinsics.checkNotNull(map2);
                reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_NAME, String.valueOf(map2.get("name")));
            }
        }
        reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_ID, material.f30533id);
        VideoReport.setElementParams(v3, reportMap);
        VideoReport.setElementEndExposePolicy(v3, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_ALL);
        VideoReport.setElementId(v3, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRICS_ITEM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(WinkEditorLyricStickerAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.B().size() > 1) {
            this$0.P(1, this$0.B().get(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ab
    public void n0(@Nullable ab.a vh5, int position, @NotNull MetaMaterial material) {
        int i3;
        Intrinsics.checkNotNullParameter(material, "material");
        super.n0(vh5, position, material);
        MetaMaterial metaMaterial = B().get(position);
        if (vh5 == null) {
            return;
        }
        TextView textView = (TextView) vh5.itemView.findViewById(R.id.f109126ez);
        Resources resources = textView.getContext().getResources();
        if (D() == position) {
            i3 = R.color.bfp;
        } else {
            i3 = R.color.bfq;
        }
        textView.setTextColor(resources.getColor(i3));
        s0(vh5.itemView, material);
        Map<String, String> map = metaMaterial.additionalFields;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (map.containsKey("name")) {
                TextView textView2 = (TextView) vh5.itemView.findViewById(R.id.f109126ez);
                Map<String, String> map2 = metaMaterial.additionalFields;
                Intrinsics.checkNotNull(map2);
                textView2.setText(String.valueOf(map2.get("name")));
            }
        }
        if (!WinkEditorResourceManager.a1().q(material) && com.tencent.mobileqq.wink.editor.c.x(material) < 0) {
            if (com.tencent.mobileqq.wink.editor.c.w(material)) {
                ImageView imageView = vh5.G;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ImageView imageView2 = vh5.f326926i;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
            } else {
                ImageView imageView3 = vh5.f326926i;
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                }
                ImageView imageView4 = vh5.G;
                if (imageView4 != null) {
                    imageView4.setVisibility(4);
                }
                WinkDownLoadingView winkDownLoadingView = vh5.f326927m;
                if (winkDownLoadingView != null) {
                    winkDownLoadingView.setVisibility(4);
                }
            }
        } else {
            ImageView imageView5 = vh5.f326926i;
            if (imageView5 != null) {
                imageView5.setVisibility(4);
            }
            ImageView imageView6 = vh5.G;
            if (imageView6 != null) {
                imageView6.setVisibility(4);
            }
        }
        if (Intrinsics.areEqual(metaMaterial.f30533id, "no_lyrics")) {
            ((TextView) vh5.itemView.findViewById(R.id.f109126ez)).setText("\u65e0\u6b4c\u8bcd");
            vh5.f326926i.setVisibility(4);
        }
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    @NotNull
    protected ab.a o0(@Nullable ViewGroup parent, int viewType) {
        return new ab.a(LayoutInflater.from(this.mContext).inflate(R.layout.hdk, parent, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@Nullable RecyclerView.ViewHolder holder, int position, @Nullable List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        onBindViewHolder(holder, position);
        EventCollector.getInstance().onRecyclerBindViewHolder(holder, position, payloads, getItemId(position));
    }

    public final int t0(@Nullable String materialID) {
        if (materialID == null) {
            return 0;
        }
        int size = B().size();
        for (int i3 = 0; i3 < size; i3++) {
            if (Intrinsics.areEqual(materialID, B().get(i3).f30533id)) {
                return i3;
            }
        }
        return 0;
    }

    public final void u0(@Nullable List<MetaMaterial> data) {
        if (data == null) {
            return;
        }
        Y(data);
        notifyDataSetChanged();
        if (B().size() > 1) {
            Function0<Unit> function0 = this.setDefaultLyricStickerBlock;
            if (function0 != null) {
                function0.invoke();
            }
            this.setDefaultLyricStickerBlock = null;
        }
    }

    public final void v0() {
        if (B().size() > 1) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.a
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorLyricStickerAdapter.w0(WinkEditorLyricStickerAdapter.this);
                }
            });
        } else {
            this.setDefaultLyricStickerBlock = new WinkEditorLyricStickerAdapter$setDefaultData$2(this);
        }
    }
}
