package com.tencent.mobileqq.troop.file.main.part;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.bc;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/part/TroopFileMainGuidePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "F9", "", "D9", "E9", "Landroid/view/View;", TtmlNode.TAG_LAYOUT, "A9", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "d", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "getViewModel", "()Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "viewModel", "e", "Z", "hasShowGuideDialog", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "f", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "entity", "", "C9", "()I", "from", "<init>", "(Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileMainGuidePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopFileMainVM viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasShowGuideDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy entity;

    public TroopFileMainGuidePart(TroopFileMainVM viewModel) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntityV2>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainGuidePart$entity$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MMKVOptionEntityV2 invoke() {
                return QMMKV.fromV2(bc.a(TroopFileMainGuidePart.this).getApp(), QMMKVFile.FILE_TROOP);
            }
        });
        this.entity = lazy;
    }

    private final void A9(View layout) {
        Bitmap createBitmap;
        int width = layout.getWidth();
        int height = layout.getHeight();
        if (width == 0 || height == 0 || (createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)) == null) {
            return;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-872415232);
        canvas.drawRect(new Rect(0, 0, width, height), paint);
        paint.setColor(16777215);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawCircle(width - r1, ViewUtils.dpToPx(5.0f) + r1, ViewUtils.dpToPx(20.0f), paint);
        layout.setBackgroundDrawable(new BitmapDrawable(createBitmap));
    }

    private final MMKVOptionEntityV2 B9() {
        return (MMKVOptionEntityV2) this.entity.getValue();
    }

    private final int C9() {
        return this.viewModel.T1().from;
    }

    private final boolean D9() {
        return B9().getBoolean("troop_file_has_show_guide_" + bc.a(this).getCurrentAccountUin(), false);
    }

    private final void E9() {
        B9().putBoolean("troop_file_has_show_guide_" + bc.a(this).getCurrentAccountUin(), true);
        B9().commit();
    }

    private final void F9() {
        if (this.hasShowGuideDialog || C9() == 5000) {
            return;
        }
        this.hasShowGuideDialog = true;
        if (!TroopFileUtils.a(bc.a(this), this.viewModel.T1().troopUinL) || D9()) {
            return;
        }
        E9();
        final View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f168595ai1, (ViewGroup) null);
        final Dialog dialog = new Dialog(getActivity(), R.style.f173448dl);
        dialog.setContentView(inflate);
        dialog.show();
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.troop.file.main.part.n
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                TroopFileMainGuidePart.G9(TroopFileMainGuidePart.this, inflate);
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.main.part.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopFileMainGuidePart.H9(dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(TroopFileMainGuidePart this$0, View layout) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(layout, "layout");
            this$0.A9(layout);
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "show_guide_view")) {
            F9();
        }
    }
}
