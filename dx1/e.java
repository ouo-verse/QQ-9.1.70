package dx1;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotImageInfo;
import cx1.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends RecyclerView.Adapter<a> {
    public Context C;

    /* renamed from: m, reason: collision with root package name */
    private List<GProRobotImageInfo> f395155m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a extends RecyclerView.ViewHolder {
        ImageView E;
        TextView F;

        public a(@NonNull View view) {
            super(view);
            this.F = (TextView) view.findViewById(R.id.f27170fi);
            this.E = (ImageView) view.findViewById(R.id.fyj);
        }
    }

    public e(@NonNull List<GProRobotImageInfo> list, @NonNull Context context) {
        this.f395155m = list;
        this.C = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(int i3, a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<GProRobotImageInfo> it = this.f395155m.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUrl());
        }
        m0(i3, aVar.E, arrayList);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f395155m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull final a aVar, final int i3) {
        GProRobotImageInfo gProRobotImageInfo = this.f395155m.get(i3);
        aVar.F.setText(gProRobotImageInfo.getDesc());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = this.C.getDrawable(R.drawable.kw6);
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        aVar.E.setImageDrawable(URLDrawable.getDrawable(gProRobotImageInfo.getUrl(), obtain));
        aVar.E.setOnClickListener(new View.OnClickListener() { // from class: dx1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.j0(i3, aVar, view);
            }
        });
        y.b(aVar.E, i3, this.f395155m.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(this.C).inflate(R.layout.f5i, (ViewGroup) null));
    }

    public void m0(int i3, ImageView imageView, ArrayList<String> arrayList) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("index", i3);
        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
        bundle.putBoolean("from_photo_wall", true);
        bundle.putBoolean("SHOW_MENU", false);
        bundle.putBoolean("IS_EDIT", false);
        bundle.putBoolean("is_use_path", true);
        bundle.putBoolean("is_show_action", true);
        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, true);
        int[] iArr = new int[2];
        imageView.getLocationOnScreen(iArr);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(Integer.valueOf(iArr[0]));
        arrayList2.add(Integer.valueOf(iArr[1]));
        arrayList2.add(Integer.valueOf(imageView.getWidth()));
        arrayList2.add(Integer.valueOf(imageView.getHeight()));
        bundle.putIntegerArrayList("mPreviewPhotoLocation", arrayList2);
        intent.putExtras(bundle);
        RouteUtils.startActivity(this.C, intent, RouterConstants.UI_ROUTE_OPEN_TROOP_AVATAR_WALL_PREVIEW_ACTIVITY);
    }
}
