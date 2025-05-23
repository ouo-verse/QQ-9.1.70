package com.qzone.feed.ui.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.business.vip.QZoneVIPUtils;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.widget.AvatarImageView;
import com.qzone.widget.FeedImageView;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedRelationListItemView extends FrameLayout {
    private TextView C;
    private CellTextView D;
    private CellTextView E;
    private View F;
    private int G;
    private int H;
    private int I;
    private g J;
    View.OnClickListener K;
    private View.OnClickListener L;
    private TextCellLayout.OnCellClickListener M;

    /* renamed from: d, reason: collision with root package name */
    private Context f47346d;

    /* renamed from: e, reason: collision with root package name */
    private AvatarImageView f47347e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f47348f;

    /* renamed from: h, reason: collision with root package name */
    private View f47349h;

    /* renamed from: i, reason: collision with root package name */
    private FeedImageView f47350i;

    /* renamed from: m, reason: collision with root package name */
    private CellTextView f47351m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedRelationListItemView.this.J.onClick(view, FeedElement.FEED_SIGN_GOTO_DETAIL, FeedRelationListItemView.this.G, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if (id5 == R.id.f27) {
                FeedRelationListItemView.this.J.onClick(view, FeedElement.NOTHING, FeedRelationListItemView.this.G, null);
            } else if (id5 == R.id.deo) {
                FeedRelationListItemView.this.J.onClick(view, FeedElement.USER_AVATAR, FeedRelationListItemView.this.G, view.getTag());
            } else if (id5 == R.id.i6l) {
                FeedRelationListItemView.this.J.onClick(view, FeedElement.VIP_ICON, FeedRelationListItemView.this.G, view.getTag());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FeedRelationListItemView(Context context) {
        super(context);
        this.K = new a();
        this.L = new b();
        this.M = new c();
        this.f47346d = context;
        this.H = getResources().getDimensionPixelSize(R.dimen.amq);
        this.I = getResources().getColor(R.color.f157907a83);
        f();
        c();
    }

    private void c() {
        this.F.setOnClickListener(this.L);
        this.f47347e.setOnClickListener(this.L);
        this.f47351m.setCellClickable(true);
        this.f47351m.setOnCellClickListener(this.M);
        this.E.setCellClickable(true);
        this.E.setOnCellClickListener(this.M);
        this.E.setOnClickListener(this.K);
        this.E.setLongclickable(true);
    }

    private void f() {
        View inflate = LayoutInflater.from(this.f47346d).inflate(R.layout.bqx, (ViewGroup) null);
        this.F = inflate;
        addView(inflate);
        this.f47349h = findViewById(R.id.c5r);
        this.f47347e = (AvatarImageView) findViewById(R.id.deo);
        this.f47348f = (ImageView) findViewById(R.id.i6l);
        this.f47351m = (CellTextView) findViewById(R.id.jj8);
        this.C = (TextView) findViewById(R.id.f166977jj3);
        CellTextView cellTextView = (CellTextView) findViewById(R.id.ji6);
        this.D = cellTextView;
        cellTextView.setCellClickable(false);
        this.D.setClickable(false);
        this.E = (CellTextView) findViewById(R.id.jgg);
        this.f47350i = (FeedImageView) findViewById(R.id.de8);
    }

    private void g(long j3) {
        this.f47347e.j(j3);
        this.f47347e.setTag(Long.valueOf(j3));
    }

    public TextCell e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        TextCell textCell = new TextCell();
        textCell.text = str;
        return textCell;
    }

    @Override // android.view.View
    public Bitmap getDrawingCache() {
        return null;
    }

    public void setContent(String str, User user, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        this.E.setVisibility(isEmpty ? 8 : 0);
        ArrayList<TextCell> arrayList = new ArrayList<>();
        if (isEmpty) {
            return;
        }
        TextCell e16 = e(str);
        if (e16 != null) {
            arrayList.add(e16);
        }
        TextCell d16 = d(user);
        if (d16 != null) {
            arrayList.add(d16);
        }
        this.E.setmutiRichText(arrayList, str2);
    }

    public void setOnFeedElementClickListener(g gVar) {
        this.J = gVar;
    }

    public void setPicture(ArrayList<PictureItem> arrayList, int i3, PictureUrl pictureUrl) {
        this.D.setVisibility(8);
        if ((arrayList == null || arrayList.size() <= 0 || arrayList.get(0) == null || arrayList.get(0).currentUrl == null || TextUtils.isEmpty(arrayList.get(0).currentUrl.url)) && i3 != 5 && pictureUrl == null) {
            this.f47350i.setVisibility(8);
            return;
        }
        this.f47350i.setDefaultImage(R.drawable.at8);
        this.f47350i.setFailImage(R.drawable.at_);
        this.f47350i.setVisibility(0);
        FeedImageView feedImageView = this.f47350i;
        int i16 = this.H;
        feedImageView.setAsyncImageProcessor(new SpecifiedSizeCropByPivotProcessor(i16, i16));
        FeedImageView feedImageView2 = this.f47350i;
        int i17 = this.H;
        feedImageView2.setAsyncClipSize(i17, i17);
        if (pictureUrl == null && i3 != 5) {
            this.f47350i.setContentDescription(this.f47346d.getResources().getText(R.string.gqq));
            if (arrayList != null) {
                this.f47350i.setAsyncImage(arrayList.get(0).currentUrl.url);
            }
            this.f47350i.setImageType(0);
            this.f47350i.setIconPosition(6);
            return;
        }
        this.f47350i.setContentDescription(this.f47346d.getResources().getText(R.string.gqr));
        if (pictureUrl != null) {
            this.f47350i.setAsyncImage(pictureUrl.url);
        } else {
            this.f47350i.setAsyncImage(null);
        }
        if (i3 == 2) {
            this.f47350i.setImageType(9, false);
            this.f47350i.setIconPosition(5);
        } else if (i3 == 3) {
            this.f47350i.setImageType(3, false);
            this.f47350i.setIconPosition(2);
        } else {
            if (i3 != 5) {
                return;
            }
            this.f47350i.setImageType(6, false);
            this.f47350i.setIconPosition(2);
        }
    }

    public void setPosition(int i3) {
        this.G = i3;
        if (i3 == 0) {
            this.f47349h.setVisibility(8);
        } else {
            this.f47349h.setVisibility(0);
        }
    }

    public void setPublishTimeDesc(String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        this.C.setVisibility(isEmpty ? 8 : 0);
        TextView textView = this.C;
        if (isEmpty) {
            str = "";
        }
        textView.setText(str);
    }

    public void setSummary(String str) {
        this.D.setVisibility(0);
        this.D.setRichText(str);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements TextCellLayout.OnCellClickListener {
        c() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater onTextOperater) {
            return false;
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell textCell, View view) {
            if (textCell == null || FeedRelationListItemView.this.J == null) {
                return;
            }
            int i3 = textCell.type;
            if (i3 == 3) {
                FeedRelationListItemView.this.J.onClick(view, FeedElement.USER_NICKNAME, FeedRelationListItemView.this.G, textCell.getUin());
                return;
            }
            if (i3 == 4) {
                if (!TextUtils.isEmpty(textCell.getPost())) {
                    view.setTag(textCell.getPost().getBytes());
                }
                FeedRelationListItemView.this.J.onClick(view, FeedElement.URL, FeedRelationListItemView.this.G, new e(textCell.getUrl(), textCell.getPost(), FeedRelationListItemView.this.G));
            } else if (i3 == 5) {
                FeedRelationListItemView.this.J.onClick(view, FeedElement.FEED_SIGN_GOTO_DETAIL, FeedRelationListItemView.this.G, null);
            } else if (i3 == 18) {
                FeedRelationListItemView.this.J.onClick(view, FeedElement.SIGN_PACK_OR_UNPACK, FeedRelationListItemView.this.G, null);
            }
        }
    }

    @Override // android.view.View
    public Bitmap getDrawingCache(boolean z16) {
        return null;
    }

    public void setNickName(User user) {
        if (user != null) {
            long j3 = user.uin;
            String str = user.nickName;
            if (!TextUtils.isEmpty(str)) {
                this.f47351m.setVisibility(0);
                if (str.trim().equals("")) {
                    str = String.valueOf(j3);
                }
                this.f47351m.setTag(Long.valueOf(j3));
                UserNameCell userNameCell = new UserNameCell(3);
                userNameCell.setUin(Long.valueOf(user.uin));
                userNameCell.text = str;
                if (user.vipLevel > 0 && user.vip != 0) {
                    userNameCell.setTextColor(getResources().getColor(R.color.f157924ab3));
                } else {
                    userNameCell.setTextColor(this.I);
                }
                this.f47351m.setText(userNameCell);
                this.f47351m.setTextColor(this.I);
                return;
            }
            this.f47351m.setVisibility(8);
        }
    }

    public TextCell d(User user) {
        long j3;
        String str;
        if (user != null) {
            j3 = user.uin;
            str = user.nickName;
        } else {
            j3 = 0;
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.trim().equals("")) {
            str = String.valueOf(j3);
        }
        UserNameCell userNameCell = new UserNameCell(3);
        userNameCell.setUin(Long.valueOf(user.uin));
        userNameCell.text = str;
        userNameCell.setTextColor(this.I);
        return userNameCell;
    }

    public void setUser(User user) {
        if (user == null) {
            return;
        }
        this.f47347e.setContentDescription(user.nickName + ((Object) this.f47346d.getResources().getText(R.string.gqz)));
        this.f47351m.setContentDescription(user.nickName);
        g(user.uin);
        setNickName(user);
        QZoneVIPUtils.e(this.f47348f, user, this.L, this.f47346d);
    }
}
