package com.tencent.mobileqq.wink.picker.core.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.wink.picker.core.adapter.a;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkAlbumListViewModel;
import com.tencent.mobileqq.wink.utils.aa;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import java.net.URL;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a extends RecyclerView.Adapter<b> {
    public static final ColorDrawable F = new ColorDrawable(-2141891243);
    private List<QQAlbumInfo> C;
    private final WinkAlbumListViewModel D;
    private final InterfaceC9068a E;

    /* renamed from: m, reason: collision with root package name */
    private final Context f324471m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.picker.core.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC9068a {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b extends RecyclerView.ViewHolder {
        public b(@NonNull View view) {
            super(view);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0054, code lost:
        
            if (r2.equals(r4.getURL()) != false) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void m(QQAlbumInfo qQAlbumInfo) {
            URLDrawable uRLDrawable;
            String str;
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.f164257p5);
            ImageView imageView2 = (ImageView) this.itemView.findViewById(R.id.slc);
            LocalMediaInfo localMediaInfo = qQAlbumInfo.mCoverInfo;
            localMediaInfo.thumbHeight = 300;
            localMediaInfo.thumbWidth = 300;
            if ("qzone_album".equals(qQAlbumInfo.f203112id)) {
                imageView.setImageResource(R.drawable.qvideo_skin_imageselector_albumcover_qzone);
                imageView2.setImageResource(R.drawable.m2m);
                imageView2.setVisibility(0);
                return;
            }
            URL p16 = p(qQAlbumInfo);
            if (imageView.getDrawable() instanceof URLDrawable) {
                uRLDrawable = (URLDrawable) imageView.getDrawable();
            }
            uRLDrawable = null;
            if (uRLDrawable == null) {
                ColorDrawable colorDrawable = a.F;
                uRLDrawable = aa.getDrawable(p16, colorDrawable, colorDrawable);
                uRLDrawable.setTag(qQAlbumInfo.mCoverInfo);
            }
            imageView.setImageDrawable(uRLDrawable);
            imageView2.setImageResource(R.drawable.qui_check_brand_standard);
            if (a.this.D.U1().getValue() != null) {
                str = a.this.D.U1().getValue().f203112id;
            } else {
                str = "";
            }
            String str2 = qQAlbumInfo.f203112id;
            if (str2 != null && str2.equals(str)) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
        }

        private void n(QQAlbumInfo qQAlbumInfo) {
            String str;
            TextView textView = (TextView) this.itemView.findViewById(R.id.album_item_title);
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.sl9);
            textView.setText(qQAlbumInfo.name);
            if (qQAlbumInfo.mMediaFileCount > 0) {
                str = String.format(Locale.getDefault(), "(%d)", Integer.valueOf(qQAlbumInfo.mMediaFileCount));
            } else {
                str = "";
            }
            textView2.setText(str);
        }

        private URL p(QQAlbumInfo qQAlbumInfo) {
            if (QAlbumUtil.getMediaType(qQAlbumInfo.mCoverInfo) == 1) {
                LocalMediaInfo localMediaInfo = qQAlbumInfo.mCoverInfo;
                if (localMediaInfo.isSystemMeidaStore) {
                    return QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "VIDEO");
                }
                return QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "APP_VIDEO");
            }
            return QAlbumUtil.generateAlbumThumbURL(qQAlbumInfo.mCoverInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(QQAlbumInfo qQAlbumInfo, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if ("qzone_album".equals(qQAlbumInfo.f203112id) && a.this.E != null) {
                a.this.E.a();
                a.this.D.b2();
                com.tencent.mobileqq.wink.picker.report.a.u(this.itemView);
            } else {
                a.this.D.c2(qQAlbumInfo);
                a.this.D.b2();
                a.this.notifyDataSetChanged();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void o(int i3) {
            final QQAlbumInfo qQAlbumInfo;
            if (!ArrayUtils.isOutOfArrayIndex(i3, a.this.C) && (qQAlbumInfo = (QQAlbumInfo) a.this.C.get(i3)) != null && a.this.D != null) {
                n(qQAlbumInfo);
                m(qQAlbumInfo);
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.adapter.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.b.this.q(qQAlbumInfo, view);
                    }
                });
            }
        }
    }

    public a(Context context, WinkAlbumListViewModel winkAlbumListViewModel, InterfaceC9068a interfaceC9068a) {
        this.f324471m = context;
        this.D = winkAlbumListViewModel;
        this.E = interfaceC9068a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<QQAlbumInfo> list = this.C;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i3) {
        bVar.o(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new b(LayoutInflater.from(this.f324471m).inflate(R.layout.hck, (ViewGroup) null));
    }

    public void n0(List<QQAlbumInfo> list) {
        this.C = list;
        notifyDataSetChanged();
    }
}
