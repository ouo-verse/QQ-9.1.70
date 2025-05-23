package pt1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f427097a;

    /* renamed from: b, reason: collision with root package name */
    public GuildWavAvatarImageView f427098b;

    /* renamed from: c, reason: collision with root package name */
    public FrameLayout f427099c;

    /* renamed from: d, reason: collision with root package name */
    public LinearLayout f427100d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f427101e;

    /* renamed from: f, reason: collision with root package name */
    public FrameLayout f427102f;

    /* renamed from: g, reason: collision with root package name */
    public LottieAnimationView f427103g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f427104h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f427105i;

    public View a(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f427097a = linearLayout;
        linearLayout.setClipChildren(false);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.height = (int) resources.getDimension(R.dimen.c_d);
        FrameLayout frameLayout = new FrameLayout(context, null);
        frameLayout.setClipChildren(false);
        linearLayout.addView(frameLayout, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.width = (int) TypedValue.applyDimension(1, 46.0f, displayMetrics);
        layoutParams2.height = (int) TypedValue.applyDimension(1, 46.0f, displayMetrics);
        GuildWavAvatarImageView guildWavAvatarImageView = new GuildWavAvatarImageView(context, null);
        this.f427098b = guildWavAvatarImageView;
        guildWavAvatarImageView.setId(R.id.wt6);
        this.f427098b.t("avatar_width", Integer.valueOf((int) TypedValue.applyDimension(1, 46.0f, displayMetrics)));
        this.f427098b.t("avatar_height", Integer.valueOf((int) TypedValue.applyDimension(1, 46.0f, displayMetrics)));
        frameLayout.addView(this.f427098b, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) TypedValue.applyDimension(1, 46.0f, displayMetrics);
        layoutParams3.height = (int) TypedValue.applyDimension(1, 46.0f, displayMetrics);
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        this.f427099c = frameLayout2;
        frameLayout2.setBackgroundResource(R.drawable.guild_audio_media_item_third_app_onlook_bg);
        this.f427099c.setId(R.id.wt7);
        frameLayout.addView(this.f427099c, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        layoutParams4.height = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        layoutParams4.gravity = 17;
        ImageView imageView = new ImageView(context, null);
        imageView.setImageResource(R.drawable.guild_audio_media_item_game_status);
        this.f427099c.addView(imageView, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams5.height = (int) resources.getDimension(R.dimen.f158713n2);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f427100d = linearLayout2;
        linearLayout2.setBackgroundResource(R.drawable.guild_audio_queue_number_bg);
        this.f427100d.setId(R.id.vzi);
        this.f427100d.setVisibility(8);
        frameLayout.addView(this.f427100d, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.width = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams6.height = (int) resources.getDimension(R.dimen.f158713n2);
        layoutParams6.gravity = 17;
        TextView textView = new TextView(context, null);
        this.f427101e = textView;
        textView.setId(R.id.vzh);
        this.f427101e.setText("1");
        this.f427101e.setTextSize(0, (int) resources.getDimension(R.dimen.f159562aw3));
        this.f427101e.setMaxLines(1);
        this.f427101e.setGravity(17);
        this.f427101e.setTextColor(resources.getColor(R.color.f158017al3));
        this.f427101e.setTypeface(Typeface.create("DIN-NextLT-Pro-QQ", 0));
        this.f427100d.addView(this.f427101e, layoutParams6);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) TypedValue.applyDimension(1, 20.0f, displayMetrics);
        layoutParams7.height = (int) TypedValue.applyDimension(1, 20.0f, displayMetrics);
        FrameLayout frameLayout3 = new FrameLayout(context, null);
        this.f427102f = frameLayout3;
        frameLayout3.setBackgroundResource(R.drawable.guild_media_onlooker_item_raise_hand_bg);
        this.f427102f.setId(R.id.wqe);
        frameLayout.addView(this.f427102f, layoutParams7);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        layoutParams8.height = (int) TypedValue.applyDimension(1, 16.0f, displayMetrics);
        layoutParams8.gravity = 17;
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context, null);
        this.f427103g = lottieAnimationView;
        lottieAnimationView.setId(R.id.wqf);
        this.f427102f.addView(this.f427103g, layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.width = -1;
        layoutParams9.topMargin = (int) TypedValue.applyDimension(1, 10.0f, displayMetrics);
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        linearLayout3.setGravity(16);
        linearLayout3.setOrientation(0);
        linearLayout.addView(linearLayout3, layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.width = (int) TypedValue.applyDimension(1, 0.0f, displayMetrics);
        layoutParams10.weight = 1.0f;
        TextView textView2 = new TextView(context, null);
        this.f427104h = textView2;
        textView2.setId(R.id.wt9);
        this.f427104h.setTextSize(0, (int) TypedValue.applyDimension(2, 12.0f, displayMetrics));
        this.f427104h.setLines(1);
        this.f427104h.setEllipsize(TextUtils.TruncateAt.END);
        this.f427104h.setGravity(17);
        this.f427104h.setIncludeFontPadding(false);
        this.f427104h.setTextColor(resources.getColor(R.color.bsb));
        linearLayout3.addView(this.f427104h, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.gravity = 1;
        layoutParams11.leftMargin = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        TextView textView3 = new TextView(context, null);
        this.f427105i = textView3;
        textView3.setText(R.string.f140130d5);
        this.f427105i.setTextSize(0, (int) resources.getDimension(R.dimen.f158729nj));
        this.f427105i.setTextColor(resources.getColor(R.color.f158017al3));
        this.f427105i.setBackgroundResource(R.drawable.guild_admin_role_icon_bg);
        this.f427105i.setId(R.id.wt8);
        this.f427105i.setGravity(17);
        this.f427105i.setVisibility(8);
        this.f427105i.setIncludeFontPadding(false);
        this.f427105i.setPadding((int) TypedValue.applyDimension(1, 4.0f, displayMetrics), (int) TypedValue.applyDimension(1, 2.0f, displayMetrics), (int) TypedValue.applyDimension(1, 4.0f, displayMetrics), (int) TypedValue.applyDimension(1, 2.0f, displayMetrics));
        linearLayout3.addView(this.f427105i, layoutParams11);
        return linearLayout;
    }
}
