package p73;

import android.content.Context;
import com.tencent.mobileqq.wink.editor.sticker.selector.adapter.WinkStickerTimeColumnType;
import com.tencent.mobileqq.wink.editor.sticker.selector.adapter.WinkStickerTimeDateType;
import com.tencent.mobileqq.wink.view.selector.WinkPickerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B)\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lp73/b;", "Lcom/tencent/mobileqq/wink/view/selector/a;", "", "e", "Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/WinkStickerTimeDateType;", "Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/WinkStickerTimeDateType;", "type", "Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/a;", "f", "Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/a;", "dataAdapter", "Lcom/tencent/mobileqq/wink/view/selector/WinkPickerView$f;", "g", "Lcom/tencent/mobileqq/wink/view/selector/WinkPickerView$f;", "pickListener", "Landroid/content/Context;", "context", "", "isNightTheme", "defaultTimeMilli", "<init>", "(Landroid/content/Context;ZLcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/WinkStickerTimeDateType;J)V", h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends com.tencent.mobileqq.wink.view.selector.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkStickerTimeDateType type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.editor.sticker.selector.adapter.a dataAdapter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkPickerView.f pickListener;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: p73.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public /* synthetic */ class C10985b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f425685a;

        static {
            int[] iArr = new int[WinkStickerTimeColumnType.values().length];
            try {
                iArr[WinkStickerTimeColumnType.TypeYear.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WinkStickerTimeColumnType.TypeMonth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WinkStickerTimeColumnType.TypeWeek.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WinkStickerTimeColumnType.TypeDay.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f425685a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context, boolean z16, @NotNull WinkStickerTimeDateType type, long j3) {
        super(context, z16);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        com.tencent.mobileqq.wink.editor.sticker.selector.adapter.a aVar = new com.tencent.mobileqq.wink.editor.sticker.selector.adapter.a(type, j3);
        this.dataAdapter = aVar;
        this.f327140c.j(aVar, z16);
        WinkPickerView.f fVar = new WinkPickerView.f() { // from class: p73.a
            @Override // com.tencent.mobileqq.wink.view.selector.WinkPickerView.f
            public final void onItemSelected(int i3, int i16) {
                b.d(b.this, i3, i16);
            }
        };
        this.pickListener = fVar;
        this.f327140c.setPickListener(fVar);
        int columnCount = aVar.getColumnCount();
        for (int i3 = 0; i3 < columnCount; i3++) {
            this.f327140c.setSelection(i3, this.dataAdapter.c(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0, int i3, int i16) {
        int m3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkStickerTimeColumnType b16 = this$0.dataAdapter.b(i3);
        this$0.dataAdapter.q(b16, i16);
        int i17 = C10985b.f425685a[b16.ordinal()];
        if (i17 != 1 && i17 != 2) {
            if (i17 != 3) {
                if (i17 == 4 && (m3 = this$0.dataAdapter.m()) != -1) {
                    this$0.f327140c.k(m3);
                    this$0.f327140c.setSelection(m3, this$0.dataAdapter.c(m3));
                }
            } else {
                int n3 = this$0.dataAdapter.n();
                if (n3 != -1) {
                    this$0.f327140c.k(n3);
                    this$0.f327140c.setSelection(n3, this$0.dataAdapter.c(n3));
                }
                int j3 = this$0.dataAdapter.j();
                if (j3 != -1) {
                    this$0.f327140c.k(j3);
                    this$0.f327140c.setSelection(j3, this$0.dataAdapter.c(j3));
                }
                int e16 = this$0.dataAdapter.e();
                if (e16 != -1) {
                    this$0.f327140c.k(e16);
                    this$0.f327140c.setSelection(e16, this$0.dataAdapter.c(e16));
                }
            }
        } else {
            int e17 = this$0.dataAdapter.e();
            if (e17 != -1) {
                this$0.f327140c.k(e17);
                this$0.f327140c.setSelection(e17, this$0.dataAdapter.c(e17));
            }
        }
        w53.b.f("WinkStickerTimeSelectorView", "onItemSelected: column = " + i3 + ", row = " + i16);
    }

    public final long e() {
        return this.dataAdapter.d().getTimeInMillis();
    }
}
