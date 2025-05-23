package com.tencent.mm.ui.widget.edittext;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.luggage.wxa.lo.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/SysMenuHelper;", "", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper;", "helper", "", "prepareReuseMenuItems", "", "isNeedReuseMenuItems", "tryGetReuseMenus", "getSysMenu", "filterReuseMenus", "Landroid/widget/TextView;", "textView", "a", "<init>", "()V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class SysMenuHelper {

    @NotNull
    public static final SysMenuHelper INSTANCE = new SysMenuHelper();

    SysMenuHelper() {
    }

    public final void a(TextView textView) {
        ReflectUtil.INSTANCE.disableSysHandle(textView);
    }

    public final void filterReuseMenus(@NotNull SelectableEditTextHelper helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Menu mTextMenu = helper.getMTextMenu();
        if (mTextMenu == null) {
            return;
        }
        int size = mTextMenu.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = mTextMenu.getItem(i3);
            n.a(SelectableEditTextHelper.TAG, "reuse bingo:%s %s", Integer.valueOf(item.getItemId()), item.getTitle());
            Map<Integer, CharSequence> mReuseMenuItems = helper.getMReuseMenuItems();
            Integer valueOf = Integer.valueOf(item.getItemId());
            CharSequence title = item.getTitle();
            Intrinsics.checkNotNull(title);
            mReuseMenuItems.put(valueOf, title);
        }
    }

    public final boolean getSysMenu(@NotNull SelectableEditTextHelper helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (helper.getMTextMenu() == null) {
            helper.setMTextMenu(new com.tencent.luggage.wxa.mo.h(helper.getMContext()));
        }
        Menu mTextMenu = helper.getMTextMenu();
        if (mTextMenu != null) {
            mTextMenu.clear();
        }
        boolean populateMenuItems = helper.getMSysMenuConfig().populateMenuItems(helper.getMTextView(), helper.getMTextMenu());
        filterReuseMenus(helper);
        return populateMenuItems;
    }

    public final boolean isNeedReuseMenuItems(@NotNull SelectableEditTextHelper helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (helper.getMSysMenuConfig().isNeedReuseMenuItems() && helper.getMIsEnable()) {
            return true;
        }
        return false;
    }

    public final void prepareReuseMenuItems(@NotNull SelectableEditTextHelper helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        helper.getMReuseMenuItems().clear();
        if (isNeedReuseMenuItems(helper)) {
            n.c(SelectableEditTextHelper.TAG, "tryGetMenus", new Object[0]);
            tryGetReuseMenus(helper);
        }
    }

    @RequiresApi(api = 23)
    public final void tryGetReuseMenus(@NotNull SelectableEditTextHelper helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        long currentTimeMillis = System.currentTimeMillis();
        a(helper.getMTextView());
        n.c(SelectableEditTextHelper.TAG, "startInsertionActionMode SDK_INT:%s ,res:%s, duration:%s", Integer.valueOf(Build.VERSION.SDK_INT), Boolean.valueOf(getSysMenu(helper)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
