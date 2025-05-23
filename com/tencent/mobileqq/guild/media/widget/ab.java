package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ab extends GridLayoutManager {
    public ab(Context context, int i3) {
        super(context, i3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        try {
            super.assertNotInLayoutOrScroll(str);
        } catch (Exception e16) {
            QLog.e("GuildMediaSafeGridLayoutManager", 1, "assertNotInLayoutOrScroll exception : " + e16);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findFirstVisibleItemPosition() {
        try {
            return super.findFirstVisibleItemPosition();
        } catch (Exception e16) {
            if (!AppSetting.isDebugVersion()) {
                QLog.e("GuildMediaSafeGridLayoutManager", 1, "[findFirstVisibleItemPosition] exception : " + e16, e16);
                return 0;
            }
            throw e16;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findLastVisibleItemPosition() {
        try {
            return super.findLastVisibleItemPosition();
        } catch (Exception e16) {
            if (!AppSetting.isDebugVersion()) {
                QLog.e("GuildMediaSafeGridLayoutManager", 1, "[findLastVisibleItemPosition] exception : " + e16, e16);
                return 0;
            }
            throw e16;
        }
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        com.tencent.mobileqq.guild.media.core.w.c("GuildMediaSafeGridLayoutManager_onLayoutChildren");
        com.tencent.mobileqq.guild.media.core.w.b("GuildMediaSafeGridLayoutManager", "_onLayoutChildren");
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e16) {
            if (!AppSetting.isDebugVersion()) {
                QLog.e("GuildMediaSafeGridLayoutManager", 1, "[onLayoutChildren] exception : " + e16, e16);
            } else {
                throw e16;
            }
        }
        com.tencent.mobileqq.guild.media.core.w.a("GuildMediaSafeGridLayoutManager", "_onLayoutChildren");
        com.tencent.mobileqq.guild.media.core.w.d();
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i3, recycler, state);
        } catch (IndexOutOfBoundsException e16) {
            if (!AppSetting.isDebugVersion()) {
                QLog.e("GuildMediaSafeGridLayoutManager", 1, "[scrollVerticallyBy] exception : " + e16, e16);
                return 0;
            }
            throw e16;
        }
    }
}
