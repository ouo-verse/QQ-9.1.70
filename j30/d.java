package j30;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface d {
    void C(@NonNull RecyclerView.ViewHolder viewHolder);

    void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3);

    void a0(@NonNull RecyclerView.ViewHolder viewHolder);

    void b();

    void c();

    View d(View view, a aVar);

    void e(int i3);

    String getLogTag();

    void onDestroy();

    void onItemSelected(int i3);

    void onPaused();

    void onStop();
}
