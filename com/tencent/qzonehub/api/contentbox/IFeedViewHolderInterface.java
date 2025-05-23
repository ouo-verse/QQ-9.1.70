package com.tencent.qzonehub.api.contentbox;

import android.content.Intent;
import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.widget.AbsListView;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IFeedViewHolderInterface extends AbsListView.OnScrollListener {
    public static final int MSG_WHAT_FEED_UPDATE = 46;

    boolean addFeedViewToGroup(ViewGroup viewGroup, IMQMsg iMQMsg);

    void clearCache();

    void doActivityResult(int i3, int i16, Intent intent);

    void onDestroy();

    void onStart();

    void onStop();

    void setHandler(Handler handler);
}
