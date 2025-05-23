package com.tencent.mobileqq.wink.editor.openingending;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcMenuPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "success", "", "errMsg", "", "result", "costTime", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingAigcMenuPart$StyleListAdapter$StyleViewHolder$generateNewImage$1 extends Lambda implements Function4<Boolean, String, String, Long, Unit> {
    final /* synthetic */ int $position;
    final /* synthetic */ MetaMaterial $styleMaterial;
    final /* synthetic */ View $view;
    final /* synthetic */ WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter.StyleViewHolder this$0;
    final /* synthetic */ WinkEditorOpeningEndingAigcMenuPart this$1;
    final /* synthetic */ WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter this$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorOpeningEndingAigcMenuPart$StyleListAdapter$StyleViewHolder$generateNewImage$1(WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter.StyleViewHolder styleViewHolder, View view, MetaMaterial metaMaterial, WinkEditorOpeningEndingAigcMenuPart winkEditorOpeningEndingAigcMenuPart, WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter styleListAdapter, int i3) {
        super(4);
        this.this$0 = styleViewHolder;
        this.$view = view;
        this.$styleMaterial = metaMaterial;
        this.this$1 = winkEditorOpeningEndingAigcMenuPart;
        this.this$2 = styleListAdapter;
        this.$position = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(boolean z16, WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter.StyleViewHolder this$0, View view, MetaMaterial styleMaterial, long j3, String result, WinkEditorOpeningEndingAigcMenuPart this$1, WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter this$2, String errMsg, int i3) {
        boolean z17;
        String str;
        boolean z18;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(styleMaterial, "$styleMaterial");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        Intrinsics.checkNotNullParameter(this$2, "this$2");
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        if (z16) {
            String str2 = styleMaterial.f30533id;
            Intrinsics.checkNotNullExpressionValue(str2, "styleMaterial.id");
            this$0.A(view, str2, j3);
            z18 = this$0.z(result);
            if (z18) {
                OpeningEndingAigcData openingEndingAigcData = this$1.aigcData;
                if (openingEndingAigcData != null) {
                    openingEndingAigcData.setCurrentStyleIndex(i3);
                    openingEndingAigcData.getAigcImagePathMap().put(com.tencent.mobileqq.wink.editor.c.z0(styleMaterial), result);
                }
                this$2.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (errMsg.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            Context context = this$1.getContext();
            if (context != null) {
                str = context.getString(R.string.ymn);
            } else {
                str = null;
            }
            errMsg = str;
        }
        QQToast.makeText(this$1.getContext(), errMsg, 0).show();
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, String str2, Long l3) {
        invoke(bool.booleanValue(), str, str2, l3.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final boolean z16, @NotNull final String errMsg, @NotNull final String result, final long j3) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(result, "result");
        this.this$0.v();
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter.StyleViewHolder styleViewHolder = this.this$0;
        final View view = this.$view;
        final MetaMaterial metaMaterial = this.$styleMaterial;
        final WinkEditorOpeningEndingAigcMenuPart winkEditorOpeningEndingAigcMenuPart = this.this$1;
        final WinkEditorOpeningEndingAigcMenuPart.StyleListAdapter styleListAdapter = this.this$2;
        final int i3 = this.$position;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.ab
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorOpeningEndingAigcMenuPart$StyleListAdapter$StyleViewHolder$generateNewImage$1.b(z16, styleViewHolder, view, metaMaterial, j3, result, winkEditorOpeningEndingAigcMenuPart, styleListAdapter, errMsg, i3);
            }
        });
    }
}
