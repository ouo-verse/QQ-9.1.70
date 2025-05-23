package com.tencent.guild.aio.msglist.reply;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.util.ui.EmoTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f111869a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f111870b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f111871c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f111872d;

    /* renamed from: e, reason: collision with root package name */
    public LinearLayout f111873e;

    /* renamed from: f, reason: collision with root package name */
    public GuildUserAvatarView f111874f;

    /* renamed from: g, reason: collision with root package name */
    public GuildUserAvatarView f111875g;

    /* renamed from: h, reason: collision with root package name */
    public RelativeLayout f111876h;

    /* renamed from: i, reason: collision with root package name */
    public GuildUserAvatarView f111877i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f111878j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f111879k;

    private ViewGroup.LayoutParams a(Context context, ViewGroup.LayoutParams layoutParams) {
        Resources resources = context.getResources();
        layoutParams.width = -2;
        layoutParams.height = (int) resources.getDimension(R.dimen.c_4);
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=ViewGroup.LayoutParams, key=app:layout_constraintBottom_toBottomOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=ViewGroup.LayoutParams, key=app:layout_constraintTop_toTopOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=ViewGroup.LayoutParams, key=app:layout_constraintLeft_toLeftOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=ViewGroup.LayoutParams, key=app:layout_constraintRight_toRightOf, value=parent}, File : guild_aio_bubble_reply.xml");
        return layoutParams;
    }

    private ViewGroup.LayoutParams b(Context context, AbsListView.LayoutParams layoutParams) {
        Resources resources = context.getResources();
        layoutParams.width = -2;
        layoutParams.height = (int) resources.getDimension(R.dimen.c_4);
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=AbsListView.LayoutParams, key=app:layout_constraintBottom_toBottomOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=AbsListView.LayoutParams, key=app:layout_constraintTop_toTopOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=AbsListView.LayoutParams, key=app:layout_constraintLeft_toLeftOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=AbsListView.LayoutParams, key=app:layout_constraintRight_toRightOf, value=parent}, File : guild_aio_bubble_reply.xml");
        return layoutParams;
    }

    private ViewGroup.LayoutParams c(Context context, FrameLayout.LayoutParams layoutParams) {
        Resources resources = context.getResources();
        layoutParams.width = -2;
        layoutParams.height = (int) resources.getDimension(R.dimen.c_4);
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=FrameLayout.LayoutParams, key=app:layout_constraintBottom_toBottomOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=FrameLayout.LayoutParams, key=app:layout_constraintTop_toTopOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=FrameLayout.LayoutParams, key=app:layout_constraintLeft_toLeftOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=FrameLayout.LayoutParams, key=app:layout_constraintRight_toRightOf, value=parent}, File : guild_aio_bubble_reply.xml");
        return layoutParams;
    }

    private ViewGroup.LayoutParams d(Context context, LinearLayout.LayoutParams layoutParams) {
        Resources resources = context.getResources();
        layoutParams.width = -2;
        layoutParams.height = (int) resources.getDimension(R.dimen.c_4);
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=LinearLayout.LayoutParams, key=app:layout_constraintBottom_toBottomOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=LinearLayout.LayoutParams, key=app:layout_constraintTop_toTopOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=LinearLayout.LayoutParams, key=app:layout_constraintLeft_toLeftOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=LinearLayout.LayoutParams, key=app:layout_constraintRight_toRightOf, value=parent}, File : guild_aio_bubble_reply.xml");
        return layoutParams;
    }

    private ViewGroup.LayoutParams e(Context context, RadioGroup.LayoutParams layoutParams) {
        Resources resources = context.getResources();
        layoutParams.width = -2;
        layoutParams.height = (int) resources.getDimension(R.dimen.c_4);
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RadioGroup.LayoutParams, key=app:layout_constraintBottom_toBottomOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RadioGroup.LayoutParams, key=app:layout_constraintTop_toTopOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RadioGroup.LayoutParams, key=app:layout_constraintLeft_toLeftOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RadioGroup.LayoutParams, key=app:layout_constraintRight_toRightOf, value=parent}, File : guild_aio_bubble_reply.xml");
        return layoutParams;
    }

    private ViewGroup.LayoutParams f(Context context, RelativeLayout.LayoutParams layoutParams) {
        Resources resources = context.getResources();
        layoutParams.width = -2;
        layoutParams.height = (int) resources.getDimension(R.dimen.c_4);
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RelativeLayout.LayoutParams, key=app:layout_constraintBottom_toBottomOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RelativeLayout.LayoutParams, key=app:layout_constraintTop_toTopOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RelativeLayout.LayoutParams, key=app:layout_constraintLeft_toLeftOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RelativeLayout.LayoutParams, key=app:layout_constraintRight_toRightOf, value=parent}, File : guild_aio_bubble_reply.xml");
        return layoutParams;
    }

    private ViewGroup.LayoutParams g(Context context, ConstraintLayout.LayoutParams layoutParams) {
        Resources resources = context.getResources();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.c_4);
        layoutParams.bottomToBottom = 0;
        layoutParams.topToTop = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.validate();
        return layoutParams;
    }

    private ViewGroup.LayoutParams h(Context context, RecyclerView.LayoutParams layoutParams) {
        Resources resources = context.getResources();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) resources.getDimension(R.dimen.c_4);
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RecyclerView.LayoutParams, key=app:layout_constraintBottom_toBottomOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RecyclerView.LayoutParams, key=app:layout_constraintTop_toTopOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RecyclerView.LayoutParams, key=app:layout_constraintLeft_toLeftOf, value=parent}, File : guild_aio_bubble_reply.xml");
        Log.e("X2J", "invalid root attr \uff1aConstraintLayout {parent=RecyclerView.LayoutParams, key=app:layout_constraintRight_toRightOf, value=parent}, File : guild_aio_bubble_reply.xml");
        return layoutParams;
    }

    public View i(Context context, ViewGroup viewGroup, boolean z16) {
        View j3 = j(context);
        if (viewGroup == null) {
            return j3;
        }
        ViewGroup.LayoutParams k3 = k(context, viewGroup);
        if (k3 == null) {
            return j3;
        }
        if (z16) {
            viewGroup.addView(j3, k3);
            return j3;
        }
        j3.setLayoutParams(k3);
        return j3;
    }

    public View j(Context context) {
        Resources resources = context.getResources();
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f111869a = constraintLayout;
        constraintLayout.setId(R.id.f73283t5);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.bottomToBottom = 0;
        layoutParams.topToTop = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.validate();
        TextView textView = new TextView(context, null);
        this.f111870b = textView;
        textView.setId(R.id.vy7);
        this.f111870b.setLayoutParams(layoutParams);
        constraintLayout.addView(this.f111870b);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) resources.getDimension(R.dimen.ccy);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) resources.getDimension(R.dimen.f158703ms);
        layoutParams2.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = (int) resources.getDimension(R.dimen.ccx);
        layoutParams2.leftToRight = R.id.vy7;
        layoutParams2.topToTop = 0;
        layoutParams2.validate();
        TextView textView2 = new TextView(context, null);
        this.f111871c = textView2;
        textView2.setId(R.id.vy6);
        this.f111871c.setLayoutParams(layoutParams2);
        constraintLayout.addView(this.f111871c);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = -2;
        layoutParams3.baselineToBaseline = R.id.vy7;
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = (int) resources.getDimension(R.dimen.ccx);
        layoutParams3.leftToRight = R.id.vy6;
        layoutParams3.rightToLeft = R.id.vy_;
        layoutParams3.constrainedWidth = true;
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = (int) resources.getDimension(R.dimen.f158960cd0);
        layoutParams3.validate();
        EmoTextView emoTextView = new EmoTextView(context);
        this.f111872d = emoTextView;
        emoTextView.setTextSize(0, resources.getDimension(R.dimen.ayl));
        this.f111872d.setSingleLine(true);
        this.f111872d.setId(R.id.f73323t9);
        this.f111872d.setEllipsize(TextUtils.TruncateAt.END);
        this.f111872d.setGravity(17);
        this.f111872d.setLayoutParams(layoutParams3);
        constraintLayout.addView(this.f111872d);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = -2;
        layoutParams4.bottomToBottom = 0;
        layoutParams4.topToTop = 0;
        layoutParams4.rightToRight = 0;
        layoutParams4.validate();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f111873e = linearLayout;
        linearLayout.setId(R.id.vy_);
        this.f111873e.setOrientation(0);
        this.f111873e.setLayoutParams(layoutParams4);
        constraintLayout.addView(this.f111873e);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) resources.getDimension(R.dimen.ccs);
        layoutParams5.height = (int) resources.getDimension(R.dimen.ccs);
        layoutParams5.rightMargin = (int) resources.getDimension(R.dimen.f158712n1);
        GuildUserAvatarView guildUserAvatarView = new GuildUserAvatarView(context, null);
        this.f111874f = guildUserAvatarView;
        guildUserAvatarView.setId(R.id.f96875iv);
        this.f111874f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f111874f.setLayoutParams(layoutParams5);
        this.f111873e.addView(this.f111874f);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.width = (int) resources.getDimension(R.dimen.ccs);
        layoutParams6.height = (int) resources.getDimension(R.dimen.ccs);
        layoutParams6.rightMargin = (int) resources.getDimension(R.dimen.f158712n1);
        GuildUserAvatarView guildUserAvatarView2 = new GuildUserAvatarView(context, null);
        this.f111875g = guildUserAvatarView2;
        guildUserAvatarView2.setId(R.id.f96905iy);
        this.f111875g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f111875g.setLayoutParams(layoutParams6);
        this.f111873e.addView(this.f111875g);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) resources.getDimension(R.dimen.ccs);
        layoutParams7.height = (int) resources.getDimension(R.dimen.ccs);
        layoutParams7.rightMargin = (int) resources.getDimension(R.dimen.f158712n1);
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f111876h = relativeLayout;
        relativeLayout.setId(R.id.f96985j6);
        this.f111876h.setLayoutParams(layoutParams7);
        this.f111873e.addView(this.f111876h);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) resources.getDimension(R.dimen.ccs);
        layoutParams8.height = (int) resources.getDimension(R.dimen.ccs);
        GuildUserAvatarView guildUserAvatarView3 = new GuildUserAvatarView(context, null);
        this.f111877i = guildUserAvatarView3;
        guildUserAvatarView3.setId(R.id.f96935j1);
        this.f111877i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f111877i.setLayoutParams(layoutParams8);
        this.f111876h.addView(this.f111877i);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.width = -1;
        layoutParams9.height = -1;
        layoutParams9.addRule(13, -1);
        ImageView imageView = new ImageView(context, null);
        this.f111878j = imageView;
        imageView.setBackgroundResource(R.drawable.guild_aio_rich_media_msg_reply_num_bg);
        this.f111878j.setId(R.id.f25750bo);
        this.f111878j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f111878j.setVisibility(8);
        this.f111878j.setImageResource(R.drawable.guild_reply_video_flag);
        this.f111878j.setLayoutParams(layoutParams9);
        this.f111876h.addView(this.f111878j);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.width = -1;
        layoutParams10.height = -1;
        layoutParams10.addRule(13, -1);
        TextView textView3 = new TextView(context, null);
        this.f111879k = textView3;
        textView3.setBackgroundResource(R.drawable.guild_aio_rich_media_msg_reply_num_bg);
        this.f111879k.setId(R.id.f110016hd);
        this.f111879k.setTextSize(2, 11.0f);
        this.f111879k.setGravity(17);
        this.f111879k.setVisibility(8);
        this.f111879k.setTextColor(resources.getColor(R.color.f158017al3));
        this.f111879k.setLayoutParams(layoutParams10);
        this.f111876h.addView(this.f111879k);
        return constraintLayout;
    }

    public ViewGroup.LayoutParams k(Context context, ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (Class<?> cls = viewGroup.getClass(); cls != null; cls = cls.getSuperclass()) {
            String name = cls.getName();
            if ("android.widget.RelativeLayout".equals(name)) {
                return f(context, new RelativeLayout.LayoutParams(0, 0));
            }
            if ("androidx.recyclerview.widget.RecyclerView".equals(name)) {
                return h(context, new RecyclerView.LayoutParams(0, 0));
            }
            if ("android.view.ViewGroup".equals(name)) {
                return a(context, new ViewGroup.LayoutParams(0, 0));
            }
            if ("android.widget.RadioGroup".equals(name)) {
                return e(context, new RadioGroup.LayoutParams(0, 0));
            }
            if ("android.widget.LinearLayout".equals(name)) {
                return d(context, new LinearLayout.LayoutParams(0, 0));
            }
            if ("android.widget.AbsListView".equals(name)) {
                return b(context, new AbsListView.LayoutParams(0, 0));
            }
            if ("androidx.constraintlayout.widget.ConstraintLayout".equals(name)) {
                return g(context, new ConstraintLayout.LayoutParams(0, 0));
            }
            if ("android.widget.FrameLayout".equals(name)) {
                return c(context, new FrameLayout.LayoutParams(0, 0));
            }
        }
        Log.e("X2J", "error parent : " + viewGroup.toString());
        return null;
    }
}
