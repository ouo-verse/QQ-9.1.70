package com.tencent.mobileqq.matchfriend.reborn.publish.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.publish.SquareFeedPublishHideKeyboardEvent;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.inputview.QUIMultiLineInputView;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import h53.QUIInputCountCalculateStrategy;
import h53.n;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00130\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R#\u0010\u001f\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/part/SquareFeedPublishTextPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "E9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", "d", "Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", "editText", "Ls82/a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "C9", "()Ls82/a;", "viewModel", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SquareFeedPublishTextPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUIMultiLineInputView editText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    public SquareFeedPublishTextPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<s82.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTextPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final s82.a invoke() {
                return (s82.a) SquareFeedPublishTextPart.this.getViewModel(s82.a.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final s82.a C9() {
        return (s82.a) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(SquareFeedPublishTextPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIMultiLineInputView qUIMultiLineInputView = this$0.editText;
        if (qUIMultiLineInputView != null) {
            qUIMultiLineInputView.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9() {
        QUIMultiLineInputView qUIMultiLineInputView = this.editText;
        if (qUIMultiLineInputView != null) {
            qUIMultiLineInputView.requestFocus();
        }
        QUIMultiLineInputView qUIMultiLineInputView2 = this.editText;
        if (qUIMultiLineInputView2 != null) {
            qUIMultiLineInputView2.q();
        }
        QUIMultiLineInputView qUIMultiLineInputView3 = this.editText;
        if (qUIMultiLineInputView3 != null) {
            qUIMultiLineInputView3.z();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QUIMultiLineInputView qUIMultiLineInputView = this.editText;
        if (qUIMultiLineInputView != null) {
            qUIMultiLineInputView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.g
                @Override // java.lang.Runnable
                public final void run() {
                    SquareFeedPublishTextPart.this.E9();
                }
            }, 200L);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QUIMultiLineInputView qUIMultiLineInputView;
        if (!(event instanceof SquareFeedPublishHideKeyboardEvent) || (qUIMultiLineInputView = this.editText) == null) {
            return;
        }
        qUIMultiLineInputView.p();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SquareFeedPublishHideKeyboardEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        if (rootView == null) {
            return;
        }
        QUIMultiLineInputView qUIMultiLineInputView = (QUIMultiLineInputView) rootView.findViewById(R.id.okg);
        this.editText = qUIMultiLineInputView;
        if (qUIMultiLineInputView != null) {
            qUIMultiLineInputView.setBackgroundType(QUIListItemBackgroundType.None);
        }
        QUIMultiLineInputView qUIMultiLineInputView2 = this.editText;
        if (qUIMultiLineInputView2 != null) {
            qUIMultiLineInputView2.setCalculateStrategy(new QUIInputCountCalculateStrategy(1.0d, 1.0d, 1.0d, 1.0d));
        }
        QUIMultiLineInputView qUIMultiLineInputView3 = this.editText;
        if (qUIMultiLineInputView3 != null) {
            qUIMultiLineInputView3.setInputViewWatcher(new a());
        }
        rootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SquareFeedPublishTextPart.D9(SquareFeedPublishTextPart.this, view);
            }
        });
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/publish/part/SquareFeedPublishTextPart$a", "Lh53/n;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements h53.n {
        a() {
        }

        @Override // h53.k
        public void afterTextChanged(Editable s16) {
            CharSequence charSequence;
            MutableLiveData<CharSequence> O1 = SquareFeedPublishTextPart.this.C9().O1();
            QUIMultiLineInputView qUIMultiLineInputView = SquareFeedPublishTextPart.this.editText;
            if (qUIMultiLineInputView == null || (charSequence = qUIMultiLineInputView.d()) == null) {
                charSequence = "";
            }
            O1.postValue(charSequence);
        }

        @Override // h53.k
        public void f8(boolean z16) {
            n.a.a(this, z16);
        }

        @Override // h53.k
        public void onTextChanged(CharSequence s16, int start, int before, int count) {
            QUIMultiLineInputView qUIMultiLineInputView = SquareFeedPublishTextPart.this.editText;
            if (qUIMultiLineInputView != null) {
                SquareFeedPublishTextPart squareFeedPublishTextPart = SquareFeedPublishTextPart.this;
                if (qUIMultiLineInputView.e() > qUIMultiLineInputView.l()) {
                    QQToast.makeText(squareFeedPublishTextPart.getContext(), 1, "\u8d85\u8fc7\u5b57\u6570\u4e0a\u9650", 0).show();
                }
            }
        }

        @Override // h53.k
        public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
        }
    }
}
