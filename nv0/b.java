package nv0;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.tencent.icgame.game.liveroom.impl.room.util.m;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lnv0/b;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "Landroid/view/Window;", "window", "", "c", "k", "i", "", MiniChatConstants.MINI_APP_LANDSCAPE, "o", "Lh22/a;", "qqLiveRoomExtraInfo", "Lh22/a;", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "e", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a f421377e = new a(null);

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomExtraInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lnv0/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
    }

    private final void c(final Window window) {
        h22.a aVar = this.qqLiveRoomExtraInfo;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomExtraInfo");
            aVar = null;
        }
        if (!aVar.h() || window == null) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(2);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: nv0.a
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i3) {
                b.n(b.this, window, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(b this$0, Window window, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h22.a aVar = this$0.qqLiveRoomExtraInfo;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomExtraInfo");
            aVar = null;
        }
        if (!aVar.h()) {
            return;
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        m.c(decorView);
    }

    public final void o(boolean isLandscape) {
        Context context = getComponentContext().getContext();
        if (context instanceof Activity) {
            c(((Activity) context).getWindow());
        } else {
            QLog.i("ICGameHideNavComponent", 1, "activity is null");
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
