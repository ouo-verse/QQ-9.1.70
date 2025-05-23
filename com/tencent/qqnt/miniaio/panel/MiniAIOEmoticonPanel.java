package com.tencent.qqnt.miniaio.panel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.impl.CommonPanelInteractionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.miniaio.c;
import com.tencent.qqnt.miniaio.d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u001e\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0015\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010&\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%R#\u0010+\u001a\n (*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/miniaio/panel/MiniAIOEmoticonPanel;", "Lcom/tencent/qqnt/miniaio/c;", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "e", "Landroid/widget/RelativeLayout;", "i", "", "inputContent", "", "a", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "g", "()Landroid/view/ViewGroup;", "mContainerView", "Lcom/tencent/qqnt/miniaio/d;", "Lcom/tencent/qqnt/miniaio/d;", "getMCallback", "()Lcom/tencent/qqnt/miniaio/d;", "mCallback", "f", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "emoticonPanel", "Landroid/content/Context;", "kotlin.jvm.PlatformType", h.F, "()Landroid/content/Context;", "mContext", "<init>", "(Landroid/view/ViewGroup;Lcom/tencent/qqnt/miniaio/d;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MiniAIOEmoticonPanel implements c, EmoticonCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup mContainerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy emoticonPanel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContext;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/miniaio/panel/MiniAIOEmoticonPanel$a", "Lcom/tencent/mobileqq/emoticonview/api/ICommonPanelInteractionView;", "Landroid/widget/EditText;", "getAIOInput", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "getIEmoticonMainPanel", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements ICommonPanelInteractionView {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniAIOEmoticonPanel.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView
        @NotNull
        public EditText getAIOInput() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EditText) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new EditText(MiniAIOEmoticonPanel.this.h());
        }

        @Override // com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView
        @NotNull
        public IEmoticonMainPanel getIEmoticonMainPanel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return MiniAIOEmoticonPanel.this.f();
            }
            return (IEmoticonMainPanel) iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public MiniAIOEmoticonPanel(@NotNull ViewGroup mContainerView, @NotNull d mCallback) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mContainerView, "mContainerView");
        Intrinsics.checkNotNullParameter(mCallback, "mCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContainerView, (Object) mCallback);
            return;
        }
        this.mContainerView = mContainerView;
        this.mCallback = mCallback;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IEmoticonMainPanel>() { // from class: com.tencent.qqnt.miniaio.panel.MiniAIOEmoticonPanel$emoticonPanel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniAIOEmoticonPanel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IEmoticonMainPanel invoke() {
                IEmoticonMainPanel e16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (IEmoticonMainPanel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                e16 = MiniAIOEmoticonPanel.this.e();
                return e16;
            }
        });
        this.emoticonPanel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Context>() { // from class: com.tencent.qqnt.miniaio.panel.MiniAIOEmoticonPanel$mContext$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniAIOEmoticonPanel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Context invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? MiniAIOEmoticonPanel.this.g().getContext() : (Context) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mContext = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IEmoticonMainPanel e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IEmoticonMainPanelService.PanelBuilder panelInteractionListener = ((IEmoticonMainPanelService) peekAppRuntime.getRuntimeService(IEmoticonMainPanelService.class, "")).newBuilder(h(), 0).setCallBack(this).setOnlySysAndEmoji(true).setToastOffset(h().getResources().getDimensionPixelSize(R.dimen.title_bar_height)).setShowEmotionPanelDeleteButton(true).setHideAllSettingTabs(true).setAdjustColumn(true).setPanelInteractionListener(new CommonPanelInteractionListener(new a()));
        Intrinsics.checkNotNullExpressionValue(panelInteractionListener, "private fun createEmotic\u2026AllTabs()\n        }\n    }");
        IEmoticonMainPanel create = panelInteractionListener.create();
        create.hideAllTabs();
        Intrinsics.checkNotNullExpressionValue(create, "panelBuilder.create().ap\u2026  hideAllTabs()\n        }");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IEmoticonMainPanel f() {
        return (IEmoticonMainPanel) this.emoticonPanel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context h() {
        return (Context) this.mContext.getValue();
    }

    @Override // com.tencent.qqnt.miniaio.c
    public void a(@NotNull CharSequence inputContent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) inputContent);
        } else {
            Intrinsics.checkNotNullParameter(inputContent, "inputContent");
            f().updateDeleteBtnVisibility(inputContent);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mCallback.delete();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @NotNull
    public final ViewGroup g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mContainerView;
    }

    @Override // com.tencent.qqnt.miniaio.c
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        RelativeLayout view = f().getView();
        Intrinsics.checkNotNullExpressionValue(view, "emoticonPanel.view");
        return view;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(@Nullable EmoticonInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) info);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(@Nullable EmoticonInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) info)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, oldInfo, newInfo, d16);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(@Nullable EmoticonInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) info);
            return;
        }
        if (info instanceof SystemEmoticonInfo) {
            this.mCallback.oa(1, ((SystemEmoticonInfo) info).code);
        } else if (info instanceof SystemAndEmojiEmoticonInfo) {
            SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) info;
            this.mCallback.oa(systemAndEmojiEmoticonInfo.emotionType, systemAndEmojiEmoticonInfo.code);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.mCallback.e0();
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }
}
