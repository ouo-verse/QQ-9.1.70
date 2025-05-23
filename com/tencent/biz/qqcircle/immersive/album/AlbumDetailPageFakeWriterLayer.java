package com.tencent.biz.qqcircle.immersive.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumDetailFragment;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase$AlbumPageData;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/album/AlbumDetailPageFakeWriterLayer;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Intent;", "intent", "", "a", "c", "b", "", "args", "", "d", "Landroid/content/Context;", "context", "onReceive", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/inside/album/QFSLayerAlbumViewModel;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/inside/album/QFSLayerAlbumViewModel;", "getMViewModel", "()Lcom/tencent/biz/qqcircle/immersive/layer/biz/inside/album/QFSLayerAlbumViewModel;", "mViewModel", "Lcom/tencent/biz/qqcircle/immersive/album/view/QFSPersonalAlbumDetailFragment;", "fragment", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/album/view/QFSPersonalAlbumDetailFragment;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class AlbumDetailPageFakeWriterLayer extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSLayerAlbumViewModel mViewModel;

    public AlbumDetailPageFakeWriterLayer(@NotNull QFSPersonalAlbumDetailFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = fragment.getViewModel(QFSLayerAlbumViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "fragment.getViewModel(QF\u2026bumViewModel::class.java)");
        this.mViewModel = (QFSLayerAlbumViewModel) viewModel;
    }

    private final void a(Intent intent) {
        boolean z16;
        String stringExtra = intent.getStringExtra("params");
        if (!d(stringExtra)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(stringExtra);
        String string = jSONObject.getString("owner_id");
        String string2 = jSONObject.getString("id");
        Intrinsics.checkNotNullExpressionValue(string2, "json.getString(\"id\")");
        long parseLong = Long.parseLong(string2);
        String string3 = jSONObject.getString("title");
        String string4 = jSONObject.getString("description");
        String string5 = jSONObject.getString("cover_url");
        boolean z17 = true;
        try {
            QQCircleFeedBase$AlbumPageData value = this.mViewModel.O2().getValue();
            Intrinsics.checkNotNull(value);
            if (value.album.status.get() != 2) {
                z17 = false;
            }
            z16 = z17;
        } catch (Exception e16) {
            QLog.e(QFSPersonalAlbumDetailFragment.L, 1, "get draft status failed:", e16);
            z16 = false;
        }
        this.mViewModel.J2(z16, string, parseLong, string3, string4, string5);
    }

    private final void b(Intent intent) {
        String stringExtra = intent.getStringExtra("params");
        if (!d(stringExtra)) {
            return;
        }
        JSONArray jSONArray = new JSONObject(stringExtra).getJSONArray("vecFeed");
        Intrinsics.checkNotNullExpressionValue(jSONArray, "json.getJSONArray(\"vecFeed\")");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            PBField pbFromJson = GdtJsonPbUtil.pbFromJson(new FeedCloudMeta$StFeed(), jSONArray.get(i3));
            Intrinsics.checkNotNull(pbFromJson, "null cannot be cast to non-null type feedcloud.FeedCloudMeta.StFeed");
            arrayList.add((FeedCloudMeta$StFeed) pbFromJson);
        }
        this.mViewModel.I2(arrayList);
        this.mViewModel.L2();
    }

    private final void c(Intent intent) {
        String stringExtra = intent.getStringExtra("params");
        if (!d(stringExtra)) {
            return;
        }
        JSONArray jSONArray = new JSONObject(stringExtra).getJSONArray("vecFeed");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            PBField pbFromJson = GdtJsonPbUtil.pbFromJson(new FeedCloudMeta$StFeed(), jSONArray.get(i3));
            Intrinsics.checkNotNull(pbFromJson, "null cannot be cast to non-null type feedcloud.FeedCloudMeta.StFeed");
            arrayList.add((FeedCloudMeta$StFeed) pbFromJson);
        }
        this.mViewModel.K2(arrayList);
        this.mViewModel.L2();
    }

    private final boolean d(String args) {
        if (args != null && !TextUtils.isEmpty(args)) {
            return true;
        }
        QLog.e(QFSPersonalAlbumDetailFragment.L, 1, "empty or null args!");
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        try {
            Intrinsics.checkNotNull(intent);
            String action = intent.getAction();
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode != -2012742029) {
                    if (hashCode != 754752903) {
                        if (hashCode == 2029625976 && action.equals("action_fake_write_album_works_edit")) {
                            c(intent);
                        }
                    } else if (action.equals("action_fake_write_album_detail_edit")) {
                        a(intent);
                    }
                } else if (action.equals("action_fake_write_album_works_add")) {
                    b(intent);
                }
            }
            intent.removeExtra("params");
        } catch (JSONException e16) {
            QLog.e(QFSPersonalAlbumDetailFragment.L, 1, "handle reload album page parse json error:", e16);
        }
    }
}
