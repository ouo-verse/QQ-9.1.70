package lr0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.guild.api.input.impl.widget.PostMediaPreviewList;
import com.tencent.guild.api.media.album.AlbumResult;
import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.guild.api.media.album.INTGuildAlbumApi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.URL;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f extends RecyclerView.Adapter<c> {
    public static final String G = "lr0.f";
    private final Context C;
    private final Drawable D;
    private String E = "";
    private ts.a F;

    /* renamed from: m, reason: collision with root package name */
    private GuildAIOMediasRepository f415444m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f415448d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.LayoutParams f415449e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f415450f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f415451h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ com.tencent.guild.api.media.album.e f415452i;

        b(c cVar, RecyclerView.LayoutParams layoutParams, int i3, int i16, com.tencent.guild.api.media.album.e eVar) {
            this.f415448d = cVar;
            this.f415449e = layoutParams;
            this.f415450f = i3;
            this.f415451h = i16;
            this.f415452i = eVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.D0(this.f415448d);
            RecyclerView.LayoutParams layoutParams = this.f415449e;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = this.f415450f;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.f415451h;
            this.f415448d.itemView.setLayoutParams(layoutParams);
            f.this.f415444m.t(this.f415452i);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c extends RecyclerView.ViewHolder {
        public ImageView E;
        public ImageView F;
        public RelativeLayout G;
        public TextView H;
        public URLDrawable I;

        public c(View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.e16);
            this.F = (ImageView) view.findViewById(R.id.f165918y20);
            this.H = (TextView) view.findViewById(R.id.f107586at);
            this.G = (RelativeLayout) view.findViewById(R.id.kq_);
        }
    }

    public f(Context context) {
        this.C = context;
        this.D = context.getResources().getDrawable(R.drawable.asd);
    }

    private void A0(LocalMediaInfo localMediaInfo) {
        int i3 = localMediaInfo.mMediaType;
        if (i3 == 0 || i3 == 1) {
            ((INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class)).postMediaItemClick(this.F, this.C, this.E, localMediaInfo, this.f415444m.o(), new Function1() { // from class: lr0.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit v06;
                    v06 = f.this.v0((AlbumResult) obj);
                    return v06;
                }
            });
        }
    }

    private void B0(final c cVar, com.tencent.guild.api.media.album.e eVar) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(cVar.itemView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(cVar.itemView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(cVar.itemView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
        animatorSet.setDuration(200L);
        animatorSet.start();
        if (getItemCount() == 1) {
            animatorSet.addListener(new a(cVar, eVar));
            return;
        }
        final RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) cVar.itemView.getLayoutParams();
        final int measuredWidth = cVar.itemView.getMeasuredWidth();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        final int abs = Math.abs(PostMediaPreviewList.f112576f);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, measuredWidth);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: lr0.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.w0(RecyclerView.LayoutParams.this, measuredWidth, abs, cVar, valueAnimator);
            }
        });
        ofInt.setDuration(200L);
        ofInt.addListener(new b(cVar, layoutParams, measuredWidth, i3, eVar));
        ofInt.setStartDelay(100L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(c cVar) {
        cVar.itemView.setScaleX(1.0f);
        cVar.itemView.setScaleY(1.0f);
        cVar.itemView.setAlpha(1.0f);
    }

    private void p0(c cVar, com.tencent.guild.api.media.album.e eVar) {
        final LocalMediaInfo localMediaInfo = (LocalMediaInfo) eVar.d();
        cVar.G.setVisibility(8);
        int i3 = AlbumThumbDownloader.THUMB_WIDHT;
        localMediaInfo.thumbHeight = i3;
        localMediaInfo.thumbWidth = i3;
        cVar.E.setAdjustViewBounds(false);
        cVar.E.setOnClickListener(new View.OnClickListener() { // from class: lr0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.s0(localMediaInfo, view);
            }
        });
        URLDrawable uRLDrawable = cVar.I;
        if (uRLDrawable == null || !uRLDrawable.getURL().toString().equals(QAlbumUtil.PROTOCOL_ALBUM_THUMB + QzoneWebViewOfflinePlugin.STR_DEVIDER + localMediaInfo.path)) {
            URL generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(localMediaInfo);
            if (QLog.isColorLevel()) {
                QLog.d(G, 2, "GuildPostMediaPreviewAdapter,getView(),image url :" + generateAlbumThumbURL.toString());
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = this.D;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(generateAlbumThumbURL, obtain);
            drawable2.setTag(localMediaInfo);
            cVar.E.setImageDrawable(drawable2);
            cVar.I = drawable2;
        }
    }

    private void q0(c cVar, com.tencent.guild.api.media.album.e eVar) {
        URL generateAlbumThumbURL;
        cVar.G.setVisibility(0);
        final LocalMediaInfo localMediaInfo = (LocalMediaInfo) eVar.d();
        if (!localMediaInfo.isSystemMeidaStore && localMediaInfo.mDuration <= 0) {
            cVar.G.setVisibility(8);
        } else {
            cVar.G.setVisibility(0);
            cVar.H.setText(QAlbumUtil.formatTimeToString(localMediaInfo.mDuration));
        }
        cVar.E.setAdjustViewBounds(false);
        cVar.E.setOnClickListener(new View.OnClickListener() { // from class: lr0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.t0(localMediaInfo, view);
            }
        });
        if (localMediaInfo.isSystemMeidaStore) {
            generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "VIDEO");
        } else {
            generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "APP_VIDEO");
        }
        int i3 = AlbumThumbDownloader.THUMB_WIDHT;
        localMediaInfo.thumbHeight = i3;
        localMediaInfo.thumbWidth = i3;
        URLDrawable uRLDrawable = cVar.I;
        if (uRLDrawable == null || !uRLDrawable.getURL().equals(generateAlbumThumbURL)) {
            if (QLog.isColorLevel()) {
                QLog.d(G, 2, "GuildPostMediaPreviewAdapter,getView(),vedio url :" + generateAlbumThumbURL.toString());
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = this.D;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(generateAlbumThumbURL, obtain);
            drawable2.setTag(localMediaInfo);
            cVar.E.setImageDrawable(drawable2);
            cVar.I = drawable2;
            if (uRLDrawable != null) {
                uRLDrawable.cancelDownload();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(LocalMediaInfo localMediaInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        A0(localMediaInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(LocalMediaInfo localMediaInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        A0(localMediaInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(c cVar, com.tencent.guild.api.media.album.e eVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        B0(cVar, eVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit v0(AlbumResult albumResult) {
        this.f415444m.x(albumResult);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w0(RecyclerView.LayoutParams layoutParams, int i3, int i16, c cVar, ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) ((1.0f - animatedFraction) * i3);
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) ((-animatedFraction) * i16);
        cVar.itemView.setLayoutParams(layoutParams);
    }

    public void C0(int i3) {
        if (i3 >= 0 && i3 <= this.f415444m.u()) {
            this.f415444m.s(i3);
            notifyItemRemoved(i3);
            notifyItemRangeChanged(i3, getItemCount() - i3, "payload");
        }
    }

    public void E0() {
        this.f415444m.n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f415444m.u();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f415444m.l(i3).getType();
    }

    public void r0(@NotNull GuildAIOMediasRepository guildAIOMediasRepository, @NotNull ts.a aVar) {
        this.f415444m = guildAIOMediasRepository;
        this.F = aVar;
    }

    public void x0(int i3, int i16) {
        this.f415444m.m(i3, i16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final c cVar, int i3) {
        int itemViewType = getItemViewType(i3);
        final com.tencent.guild.api.media.album.e l3 = this.f415444m.l(i3);
        cVar.F.setVisibility(0);
        cVar.F.setClickable(true);
        cVar.F.setOnClickListener(new View.OnClickListener() { // from class: lr0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.u0(cVar, l3, view);
            }
        });
        if (itemViewType == 0) {
            p0(cVar, l3);
        } else if (itemViewType == 1) {
            q0(cVar, l3);
        } else {
            p0(cVar, l3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new c(LayoutInflater.from(this.C).inflate(R.layout.dv9, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f415445d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.guild.api.media.album.e f415446e;

        a(c cVar, com.tencent.guild.api.media.album.e eVar) {
            this.f415445d = cVar;
            this.f415446e = eVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.D0(this.f415445d);
            f.this.f415444m.t(this.f415446e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
