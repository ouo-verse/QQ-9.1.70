package g53;

import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonPanel;
import com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lg53/b;", "Lf53/a;", "Landroid/widget/EditText;", "editText", "Landroid/view/View;", "a", "", "destroy", "Lcom/tencent/mobileqq/emoticonview/IEmoticonPanel;", "Lcom/tencent/mobileqq/emoticonview/IEmoticonPanel;", "emoticonPanel", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b implements f53.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IEmoticonPanel emoticonPanel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"g53/b$a", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements EmoticonCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f401276d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppRuntime f401277e;

        a(EditText editText, AppRuntime appRuntime) {
            this.f401276d = editText;
            this.f401277e = appRuntime;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            TextUtils.backspace(this.f401276d);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
            EditText editText = this.f401276d;
            if (editText != null) {
                AppRuntime appRuntime = this.f401277e;
                if (info != null) {
                    info.send(appRuntime, editText.getContext(), editText, null);
                }
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(KeyEvent keyEvent) {
        return false;
    }

    @Override // f53.a
    @Nullable
    public View a(@Nullable EditText editText) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ISystemAndEmojiPanelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        IEmoticonPanel create = ((ISystemAndEmojiPanelService) runtimeService).newBuilder().c(new a(editText, peekAppRuntime)).a(editText).b(new ISystemAndEmojiPanelService.b() { // from class: g53.a
            @Override // com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService.b
            public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
                boolean c16;
                c16 = b.c(keyEvent);
                return c16;
            }
        }).create();
        this.emoticonPanel = create;
        if (create != null) {
            return create.getView();
        }
        return null;
    }

    @Override // f53.a
    public void destroy() {
        IEmoticonPanel iEmoticonPanel = this.emoticonPanel;
        if (iEmoticonPanel != null) {
            iEmoticonPanel.onDestroy();
        }
        this.emoticonPanel = null;
    }
}
