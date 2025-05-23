package com.tencent.timi.game.liveroom.impl.room.view;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b\u001f\u0010 B\u0011\b\u0017\u0012\u0006\u0010!\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog;", "Landroidx/fragment/app/DialogFragment;", "", "initView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onStart", "Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$a;", "mBuilder", "D", "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mFirstTv", UserInfo.SEX_FEMALE, "mSecondTv", "G", "mCancelTv", "H", "mConfirmTv", "<init>", "()V", "builder", "(Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$a;)V", "I", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveCustomDialog extends ReportAndroidXDialogFragment {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private Companion.C9957a mBuilder;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView mFirstTv;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mSecondTv;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView mCancelTv;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView mConfirmTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0003\u0003\t\nB\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a;", "", "Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$a;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.QQLiveCustomDialog$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R$\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$a;", "", "Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$c;", "listener", "e", "Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog;", "a", "Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$b;", "Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$b;", "b", "()Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$b;", "d", "(Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$b;)V", "dialogData", "Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$c;", "c", "()Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$c;", "setDialogOnClickListener", "(Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$c;)V", "dialogOnClickListener", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.QQLiveCustomDialog$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C9957a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private DialogData dialogData;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private c dialogOnClickListener;

            @NotNull
            public final QQLiveCustomDialog a() {
                return new QQLiveCustomDialog(this);
            }

            @Nullable
            /* renamed from: b, reason: from getter */
            public final DialogData getDialogData() {
                return this.dialogData;
            }

            @Nullable
            /* renamed from: c, reason: from getter */
            public final c getDialogOnClickListener() {
                return this.dialogOnClickListener;
            }

            public final void d(@Nullable DialogData dialogData) {
                this.dialogData = dialogData;
            }

            @NotNull
            public final C9957a e(@NotNull c listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                this.dialogOnClickListener = listener;
                return this;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "firstText", "b", "d", "secondText", "confirmText", "cancelText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.QQLiveCustomDialog$a$b, reason: from toString */
        /* loaded from: classes26.dex */
        public static final /* data */ class DialogData {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final String firstText;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final String secondText;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final String confirmText;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            @Nullable
            private final String cancelText;

            public DialogData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
                this.firstText = str;
                this.secondText = str2;
                this.confirmText = str3;
                this.cancelText = str4;
            }

            @Nullable
            /* renamed from: a, reason: from getter */
            public final String getCancelText() {
                return this.cancelText;
            }

            @Nullable
            /* renamed from: b, reason: from getter */
            public final String getConfirmText() {
                return this.confirmText;
            }

            @Nullable
            /* renamed from: c, reason: from getter */
            public final String getFirstText() {
                return this.firstText;
            }

            @Nullable
            /* renamed from: d, reason: from getter */
            public final String getSecondText() {
                return this.secondText;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DialogData)) {
                    return false;
                }
                DialogData dialogData = (DialogData) other;
                if (Intrinsics.areEqual(this.firstText, dialogData.firstText) && Intrinsics.areEqual(this.secondText, dialogData.secondText) && Intrinsics.areEqual(this.confirmText, dialogData.confirmText) && Intrinsics.areEqual(this.cancelText, dialogData.cancelText)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2;
                int hashCode3;
                String str = this.firstText;
                int i3 = 0;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int i16 = hashCode * 31;
                String str2 = this.secondText;
                if (str2 == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = str2.hashCode();
                }
                int i17 = (i16 + hashCode2) * 31;
                String str3 = this.confirmText;
                if (str3 == null) {
                    hashCode3 = 0;
                } else {
                    hashCode3 = str3.hashCode();
                }
                int i18 = (i17 + hashCode3) * 31;
                String str4 = this.cancelText;
                if (str4 != null) {
                    i3 = str4.hashCode();
                }
                return i18 + i3;
            }

            @NotNull
            public String toString() {
                return "DialogData(firstText=" + this.firstText + ", secondText=" + this.secondText + ", confirmText=" + this.confirmText + ", cancelText=" + this.cancelText + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/QQLiveCustomDialog$a$c;", "", "Landroid/view/View;", "view", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.QQLiveCustomDialog$a$c */
        /* loaded from: classes26.dex */
        public interface c {
            void a(@NotNull View view);

            void b(@NotNull View view);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final C9957a a() {
            return new C9957a();
        }

        Companion() {
        }
    }

    public QQLiveCustomDialog() {
    }

    private final void initView() {
        String str;
        String str2;
        String str3;
        View view = this.mRootView;
        if (view != null) {
            this.mFirstTv = (TextView) view.findViewById(R.id.f637534d);
            this.mSecondTv = (TextView) view.findViewById(R.id.f637634e);
            this.mCancelTv = (TextView) view.findViewById(R.id.f637334b);
            this.mConfirmTv = (TextView) view.findViewById(R.id.f637434c);
            TextView textView = this.mFirstTv;
            String str4 = null;
            if (textView != null) {
                Companion.C9957a c9957a = this.mBuilder;
                if (c9957a == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBuilder");
                    c9957a = null;
                }
                Companion.DialogData dialogData = c9957a.getDialogData();
                if (dialogData != null) {
                    str3 = dialogData.getFirstText();
                } else {
                    str3 = null;
                }
                textView.setText(str3);
            }
            TextView textView2 = this.mSecondTv;
            if (textView2 != null) {
                Companion.C9957a c9957a2 = this.mBuilder;
                if (c9957a2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBuilder");
                    c9957a2 = null;
                }
                Companion.DialogData dialogData2 = c9957a2.getDialogData();
                if (dialogData2 != null) {
                    str2 = dialogData2.getSecondText();
                } else {
                    str2 = null;
                }
                textView2.setText(str2);
            }
            TextView textView3 = this.mCancelTv;
            if (textView3 != null) {
                Companion.C9957a c9957a3 = this.mBuilder;
                if (c9957a3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBuilder");
                    c9957a3 = null;
                }
                Companion.DialogData dialogData3 = c9957a3.getDialogData();
                if (dialogData3 != null) {
                    str = dialogData3.getCancelText();
                } else {
                    str = null;
                }
                textView3.setText(str);
            }
            TextView textView4 = this.mConfirmTv;
            if (textView4 != null) {
                Companion.C9957a c9957a4 = this.mBuilder;
                if (c9957a4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBuilder");
                    c9957a4 = null;
                }
                Companion.DialogData dialogData4 = c9957a4.getDialogData();
                if (dialogData4 != null) {
                    str4 = dialogData4.getConfirmText();
                }
                textView4.setText(str4);
            }
            TextView textView5 = this.mCancelTv;
            if (textView5 != null) {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.ag
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        QQLiveCustomDialog.rh(QQLiveCustomDialog.this, view2);
                    }
                });
            }
            TextView textView6 = this.mConfirmTv;
            if (textView6 != null) {
                textView6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.ah
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        QQLiveCustomDialog.sh(QQLiveCustomDialog.this, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(QQLiveCustomDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.C9957a c9957a = this$0.mBuilder;
        if (c9957a == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBuilder");
            c9957a = null;
        }
        Companion.c dialogOnClickListener = c9957a.getDialogOnClickListener();
        if (dialogOnClickListener != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            dialogOnClickListener.a(view);
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(QQLiveCustomDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.C9957a c9957a = this$0.mBuilder;
        if (c9957a == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBuilder");
            c9957a = null;
        }
        Companion.c dialogOnClickListener = c9957a.getDialogOnClickListener();
        if (dialogOnClickListener != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            dialogOnClickListener.b(view);
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.b0s);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.mRootView = inflater.inflate(R.layout.hao, container, false);
        initView();
        View view = this.mRootView;
        Intrinsics.checkNotNull(view);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && getActivity() != null) {
            Window window = dialog.getWindow();
            Intrinsics.checkNotNull(window);
            window.setBackgroundDrawableResource(17170445);
            Window window2 = dialog.getWindow();
            Intrinsics.checkNotNull(window2);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.dimAmount = 0.0f;
            Window window3 = dialog.getWindow();
            Intrinsics.checkNotNull(window3);
            window3.setAttributes(attributes);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"ValidFragment"})
    public QQLiveCustomDialog(@NotNull Companion.C9957a builder) {
        this();
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.mBuilder = builder;
    }
}
