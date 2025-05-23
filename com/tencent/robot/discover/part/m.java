package com.tencent.robot.discover.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0002\u0003\u0019\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/robot/discover/part/m;", "Lcom/tencent/robot/discover/part/b;", "Lcom/tencent/robot/discover/viewmodel/n;", "com/tencent/robot/discover/part/m$b", "I9", "()Lcom/tencent/robot/discover/part/m$b;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Ljava/lang/Class;", "B9", "f", "Ljava/lang/String;", "mTroopUin", "com/tencent/robot/discover/part/m$c", tl.h.F, "Lcom/tencent/robot/discover/part/m$c;", "mTextWatcher", "<init>", "()V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class m extends com.tencent.robot.discover.part.b<com.tencent.robot.discover.viewmodel.n> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTroopUin = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mTextWatcher = new c();

    private final b I9() {
        return new b();
    }

    @Override // com.tencent.robot.discover.part.b
    @NotNull
    public Class<com.tencent.robot.discover.viewmodel.n> B9() {
        return com.tencent.robot.discover.viewmodel.n.class;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "msg_remove_text_watcher")) {
            z9().getInputWidget().removeTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // com.tencent.robot.discover.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        z9().setCustomResource(n34.e.f418127a.b());
        z9().getInputWidget().addTextChangedListener(this.mTextWatcher);
        z9().setActionCallback(I9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String stringExtra = activity.getIntent().getStringExtra("troop_uin");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mTroopUin = stringExtra;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/discover/part/m$b", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "", "onCancel", "", "onClear", "onBack", "", "onSearch", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements QUISearchBar.ActionCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            Activity activity = m.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return true;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/robot/discover/part/m$c", "Landroid/text/TextWatcher;", "", "text", "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable text) {
            boolean z16;
            MutableLiveData<Integer> R1;
            MutableLiveData<Integer> R12;
            if (text != null && text.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                com.tencent.robot.discover.viewmodel.n A9 = m.this.A9();
                if (A9 != null && (R12 = A9.R1()) != null) {
                    Integer value = R12.getValue();
                    Intrinsics.checkNotNull(value);
                    R12.setValue(Integer.valueOf((value.intValue() & (-2)) | 0));
                    return;
                }
                return;
            }
            com.tencent.robot.discover.viewmodel.n A92 = m.this.A9();
            if (A92 != null && (R1 = A92.R1()) != null) {
                Integer value2 = R1.getValue();
                Intrinsics.checkNotNull(value2);
                R1.setValue(Integer.valueOf(1 | (value2.intValue() & (-2))));
            }
            com.tencent.robot.discover.viewmodel.n A93 = m.this.A9();
            if (A93 != null) {
                A93.X1(text.toString(), m.this.mTroopUin, 0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}
