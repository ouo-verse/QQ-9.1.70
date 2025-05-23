package com.tencent.qqnt.aio.menu.strategy;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.api.IAIOEmoReplyMenuApi;
import com.tencent.qqnt.aio.menu.MenuWrapper;
import com.tencent.qqnt.aio.menu.al;
import com.tencent.qqnt.aio.menu.ui.QQCustomMenuExpandableLayout;
import com.tencent.qqnt.aio.menu.ui.QQCustomMenuNoIconLayout;
import com.tencent.qqnt.aio.menu.w;
import com.tencent.qqnt.aio.widget.BubblePopupWindow;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J0\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J:\u0010\u0016\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016Jy\u0010%\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/aio/menu/strategy/c;", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$b;", "Landroid/view/View;", "anchorView", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$c;", "initInfo", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$d;", "d", "Lcom/tencent/qqnt/aio/menu/al;", "selectLocation", "", "selectMenuBottomPadding", "a", "Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;", "popup", HippyTKDListViewAdapter.X, "y", "offsetWidth", "displayWidth", "", "c", "Landroid/content/Context;", "ctx", "Lcom/tencent/qqnt/aio/menu/w;", "onMenuActionListener", "", "ignoreTouchLocation", "containerBottom", "source", "showSelectMenu", "Lcom/tencent/qqnt/aio/menu/ui/QQCustomMenuNoIconLayout;", "creator", "", "msgUin", QQBrowserActivity.KEY_MSG_TYPE, "b", "(Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;Landroid/content/Context;Landroid/view/View;Lcom/tencent/qqnt/aio/menu/ui/c;Lcom/tencent/qqnt/aio/menu/w;ZLjava/lang/Integer;Landroid/view/View;ZLcom/tencent/qqnt/aio/menu/ui/QQCustomMenuNoIconLayout;Ljava/lang/String;I)Landroid/view/View;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c implements MenuWrapper.b {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String msgUin, int i3, c this$0, w onMenuActionListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msgUin, "$msgUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onMenuActionListener, "$onMenuActionListener");
        Intrinsics.checkNotNull(view);
        Object tag = view.getTag();
        if (tag instanceof com.tencent.qqnt.aio.menu.ui.d) {
            com.tencent.qqnt.aio.menu.ui.d dVar = (com.tencent.qqnt.aio.menu.ui.d) tag;
            HashMap<String, Object> a16 = MenuWrapper.INSTANCE.a(dVar.d().getMsgRecord(), msgUin, i3);
            String e16 = com.tencent.mobileqq.aio.utils.b.f194119a.e(dVar.c());
            if (TextUtils.isEmpty(e16)) {
                e16 = this$0.g(dVar.c());
            }
            a16.put("aio_longpress_menu_action_item", e16);
            com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_long_menu", a16);
        }
        onMenuActionListener.a(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.aio.menu.MenuWrapper.b
    @NotNull
    public MenuWrapper.d a(@NotNull View anchorView, @NotNull com.tencent.qqnt.aio.menu.ui.c menu, @NotNull MenuWrapper.c initInfo, @NotNull al selectLocation, int selectMenuBottomPadding) {
        int i3;
        MenuWrapper.ArrowType arrowType;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MenuWrapper.d) iPatchRedirector.redirect((short) 3, this, anchorView, menu, initInfo, selectLocation, Integer.valueOf(selectMenuBottomPadding));
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(initInfo, "initInfo");
        Intrinsics.checkNotNullParameter(selectLocation, "selectLocation");
        int b16 = selectLocation.b();
        int a16 = selectLocation.a();
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(anchorView.getContext());
        Point h16 = initInfo.h();
        if (h16 != null) {
            i3 = h16.y;
        } else {
            i3 = b16;
        }
        int intValue = initInfo.e().getSecond().intValue();
        int intValue2 = initInfo.f().getSecond().intValue();
        int b17 = com.tencent.mobileqq.aio.utils.e.f194142a.b() - selectMenuBottomPadding;
        int i18 = b16 - intValue2;
        if (i18 < initInfo.d() + statusBarHeight) {
            if (initInfo.c() + a16 < initInfo.d() + statusBarHeight) {
                if (i3 != 0 && (i16 = i3 - intValue2) > initInfo.d() + statusBarHeight) {
                    arrowType = MenuWrapper.ArrowType.IGNORE;
                } else if (i3 != 0 && (initInfo.g() + i3) - intValue2 < b17) {
                    i16 = i3 - intValue2;
                    arrowType = MenuWrapper.ArrowType.UP;
                } else {
                    i16 = initInfo.d() + statusBarHeight;
                    arrowType = MenuWrapper.ArrowType.IGNORE;
                }
                i17 = intValue;
            } else {
                i16 = initInfo.c() + a16;
                if (initInfo.g() + i16 > b17) {
                    if (i3 != 0 && (i16 = i3 - intValue2) > initInfo.d() + statusBarHeight) {
                        arrowType = MenuWrapper.ArrowType.IGNORE;
                    } else if (i3 != 0 && (initInfo.g() + i3) - intValue2 < b17) {
                        i16 = i3 - intValue2;
                        arrowType = MenuWrapper.ArrowType.UP;
                    } else {
                        i16 = initInfo.d() + statusBarHeight + initInfo.g() + intValue2;
                        arrowType = MenuWrapper.ArrowType.IGNORE;
                    }
                    i17 = intValue;
                } else {
                    arrowType = MenuWrapper.ArrowType.UP;
                }
            }
        } else {
            if (b16 <= b17) {
                b17 = i18;
            }
            arrowType = MenuWrapper.ArrowType.IGNORE;
            i16 = b17;
        }
        return new MenuWrapper.d(i17, i16, arrowType);
    }

    @Override // com.tencent.qqnt.aio.menu.MenuWrapper.b
    @NotNull
    public View b(@Nullable BubblePopupWindow popup, @NotNull Context ctx, @NotNull View anchorView, @Nullable com.tencent.qqnt.aio.menu.ui.c menu, @NotNull final w onMenuActionListener, boolean ignoreTouchLocation, @Nullable Integer containerBottom, @Nullable View source, boolean showSelectMenu, @Nullable QQCustomMenuNoIconLayout creator, @NotNull final String msgUin, final int msgType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, popup, ctx, anchorView, menu, onMenuActionListener, Boolean.valueOf(ignoreTouchLocation), containerBottom, source, Boolean.valueOf(showSelectMenu), creator, msgUin, Integer.valueOf(msgType));
        }
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(onMenuActionListener, "onMenuActionListener");
        Intrinsics.checkNotNullParameter(msgUin, "msgUin");
        com.tencent.qqnt.aio.menu.ui.e.b(menu);
        QQCustomMenuExpandableLayout qQCustomMenuExpandableLayout = new QQCustomMenuExpandableLayout(ctx);
        qQCustomMenuExpandableLayout.setViewRadius(4.0f);
        qQCustomMenuExpandableLayout.setPopupWindow(popup, new BubblePopupWindow.f() { // from class: com.tencent.qqnt.aio.menu.strategy.a
            @Override // com.tencent.qqnt.aio.widget.BubblePopupWindow.f
            public final void onMenuNoIconEmptyClick() {
                c.h();
            }
        });
        qQCustomMenuExpandableLayout.setMenu(menu, source);
        qQCustomMenuExpandableLayout.setMenuIconClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.menu.strategy.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.i(msgUin, msgType, this, onMenuActionListener, view);
            }
        });
        qQCustomMenuExpandableLayout.setIgnoreTouchLocation(ignoreTouchLocation);
        qQCustomMenuExpandableLayout.setContainerBottom(containerBottom);
        if (menu != null && menu.d() > 0 && !showSelectMenu) {
            IAIOEmoReplyMenuApi iAIOEmoReplyMenuApi = (IAIOEmoReplyMenuApi) QRoute.api(IAIOEmoReplyMenuApi.class);
            AIOMsgItem d16 = menu.b(0).d();
            Intrinsics.checkNotNullExpressionValue(d16, "menu.getItem(0).msgItem");
            qQCustomMenuExpandableLayout.setTopContainer(iAIOEmoReplyMenuApi.getDefaultEmoReplyMenuView(ctx, d16, qQCustomMenuExpandableLayout, onMenuActionListener));
        }
        qQCustomMenuExpandableLayout.G();
        return qQCustomMenuExpandableLayout;
    }

    @Override // com.tencent.qqnt.aio.menu.MenuWrapper.b
    public void c(@Nullable BubblePopupWindow popup, @NotNull View anchorView, int x16, int y16, int offsetWidth, int displayWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, popup, anchorView, Integer.valueOf(x16), Integer.valueOf(y16), Integer.valueOf(offsetWidth), Integer.valueOf(displayWidth));
            return;
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        if (popup != null) {
            popup.S(anchorView, x16, y16, true, offsetWidth, displayWidth);
        }
    }

    @Override // com.tencent.qqnt.aio.menu.MenuWrapper.b
    @NotNull
    public MenuWrapper.d d(@NotNull View anchorView, @NotNull com.tencent.qqnt.aio.menu.ui.c menu, @NotNull MenuWrapper.c initInfo) {
        int i3;
        MenuWrapper.ArrowType arrowType;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MenuWrapper.d) iPatchRedirector.redirect((short) 2, this, anchorView, menu, initInfo);
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(initInfo, "initInfo");
        int[] iArr = new int[2];
        anchorView.getLocationInWindow(iArr);
        int i17 = iArr[0];
        int i18 = iArr[1];
        int height = anchorView.getHeight() + i18;
        int intValue = initInfo.f().getSecond().intValue();
        int screenHeight = ViewUtils.getScreenHeight();
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(anchorView.getContext());
        Point h16 = initInfo.h();
        if (h16 != null) {
            i3 = h16.y;
        } else {
            i3 = i18;
        }
        int i19 = i18 - intValue;
        if (i19 < initInfo.d() + statusBarHeight) {
            if (initInfo.c() + height < initInfo.d() + statusBarHeight) {
                if (i3 != 0 && (i16 = i3 - intValue) > initInfo.d() + statusBarHeight) {
                    arrowType = MenuWrapper.ArrowType.IGNORE;
                } else if (i3 != 0 && (initInfo.g() + i3) - intValue < screenHeight) {
                    i16 = i3 - intValue;
                    arrowType = MenuWrapper.ArrowType.UP;
                } else {
                    i16 = initInfo.d() + statusBarHeight;
                    arrowType = MenuWrapper.ArrowType.IGNORE;
                }
            } else {
                i16 = initInfo.c() + height;
                if (initInfo.g() + i16 > screenHeight) {
                    if (i3 != 0 && (i16 = i3 - intValue) > initInfo.d() + statusBarHeight) {
                        arrowType = MenuWrapper.ArrowType.IGNORE;
                    } else if (i3 != 0 && (initInfo.g() + i3) - intValue < screenHeight) {
                        i16 = i3 - intValue;
                        arrowType = MenuWrapper.ArrowType.UP;
                    } else {
                        i16 = initInfo.d() + statusBarHeight + initInfo.g() + intValue;
                        arrowType = MenuWrapper.ArrowType.IGNORE;
                    }
                } else {
                    arrowType = MenuWrapper.ArrowType.UP;
                }
            }
        } else {
            if (i18 <= screenHeight) {
                screenHeight = i19;
            }
            arrowType = MenuWrapper.ArrowType.IGNORE;
            i16 = screenHeight;
        }
        return new MenuWrapper.d(i17, i16, arrowType);
    }

    @NotNull
    public String g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        return MenuWrapper.b.a.a(this, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
    }
}
