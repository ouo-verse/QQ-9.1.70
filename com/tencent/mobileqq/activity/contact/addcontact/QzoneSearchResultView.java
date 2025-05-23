package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb$ResultItem;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.en;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.widget.QzoneImagesContainer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QzoneSearchResultView extends LinearLayout {
    static IPatchRedirector $redirector_;
    private AccountSearchPb$ResultItem C;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f180749d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f180750e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f180751f;

    /* renamed from: h, reason: collision with root package name */
    public TextView f180752h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f180753i;

    /* renamed from: m, reason: collision with root package name */
    public QzoneImagesContainer f180754m;

    public QzoneSearchResultView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public static void d(BaseActivity baseActivity, String str) {
        QZoneHelper.forwardToBrowser(baseActivity, str, -1, null, null);
    }

    public void a(QQAppInterface qQAppInterface, SearchBaseFragment searchBaseFragment, AccountSearchPb$ResultItem accountSearchPb$ResultItem) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, searchBaseFragment, accountSearchPb$ResultItem);
            return;
        }
        if (accountSearchPb$ResultItem != null && searchBaseFragment != null && qQAppInterface != null) {
            setVisibility(0);
            this.C = accountSearchPb$ResultItem;
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(c()), "QzoneSearchResultView");
            if (friendsSimpleInfoWithUid != null) {
                str = friendsSimpleInfoWithUid.p();
            } else {
                str = "";
            }
            String stringUtf8 = accountSearchPb$ResultItem.nick_name.get().toStringUtf8();
            String stringUtf82 = accountSearchPb$ResultItem.name.get().toStringUtf8();
            String stringUtf83 = accountSearchPb$ResultItem.summary.get().toStringUtf8();
            List<ByteStringMicro> list = accountSearchPb$ResultItem.pic_url_list.get();
            int i16 = accountSearchPb$ResultItem.total_pic_num.get();
            long j3 = accountSearchPb$ResultItem.ftime.get();
            CharSequence e16 = en.e(getContext(), 3, 1000 * j3, false);
            SpannableString Kh = searchBaseFragment.Kh(80000004, stringUtf8);
            if (!TextUtils.isEmpty(Kh)) {
                this.f180750e.setText(Kh);
            } else if (!TextUtils.isEmpty(str)) {
                this.f180750e.setText(searchBaseFragment.Kh(80000004, str));
            } else {
                this.f180750e.setText(c());
            }
            if (j3 > 0) {
                this.f180751f.setText(e16);
                i3 = 8;
            } else {
                i3 = 8;
                this.f180751f.setVisibility(8);
            }
            SpannableString Kh2 = searchBaseFragment.Kh(80000004, stringUtf82);
            if (TextUtils.isEmpty(Kh2)) {
                this.f180752h.setVisibility(i3);
                this.f180753i.setMaxLines(2);
                this.f180753i.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.f180752h.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("\u300a");
                spannableStringBuilder.append((CharSequence) Kh2).append((CharSequence) "\u300b");
                this.f180752h.setText(spannableStringBuilder);
                this.f180753i.setMaxLines(1);
                this.f180753i.setEllipsize(TextUtils.TruncateAt.END);
            }
            SpannableString Kh3 = searchBaseFragment.Kh(80000004, stringUtf83);
            if (TextUtils.isEmpty(Kh3)) {
                this.f180753i.setVisibility(8);
            } else {
                this.f180753i.setText(Kh3);
            }
            this.f180754m.setImages(list, i16, "1".equals(accountSearchPb$ResultItem.has_video.get().toStringUtf8()));
            return;
        }
        setVisibility(8);
    }

    public void b(BaseActivity baseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseActivity);
        } else {
            QZoneHelper.forwardToDetail(baseActivity, this.C.jmp_url.get().toStringUtf8());
        }
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return String.valueOf(this.C.uin.get());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onFinishInflate();
        this.f180749d = (ImageView) findViewById(R.id.d3i);
        this.f180750e = (TextView) findViewById(R.id.cb9);
        this.f180751f = (TextView) findViewById(R.id.g5c);
        this.f180752h = (TextView) findViewById(R.id.title);
        this.f180753i = (TextView) findViewById(R.id.j8_);
        this.f180754m = (QzoneImagesContainer) findViewById(R.id.ddm);
    }

    public void setAvartaView(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
        } else if (bitmap != null) {
            this.f180749d.setVisibility(0);
            this.f180749d.setImageBitmap(bitmap);
        } else {
            this.f180749d.setVisibility(0);
            this.f180749d.setImageBitmap(BaseImageUtil.getDefaultFaceBitmap());
        }
    }

    public QzoneSearchResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
