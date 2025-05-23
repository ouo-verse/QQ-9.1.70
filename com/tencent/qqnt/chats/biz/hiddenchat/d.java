package com.tencent.qqnt.chats.biz.hiddenchat;

import android.widget.TextView;
import com.tencent.qqnt.kernel.nativeinterface.RecentHiddenSesionInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000e\u001a\u00020\b2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/biz/hiddenchat/d;", "", "", "unReadSwitch", "", "unReadNum", "Landroid/widget/TextView;", "unReadMsg", "", "a", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentHiddenSesionInfo;", "Lkotlin/collections/ArrayList;", "sessionList", "b", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface d {
    void a(boolean unReadSwitch, int unReadNum, @Nullable TextView unReadMsg);

    void b(@Nullable ArrayList<RecentHiddenSesionInfo> sessionList);
}
