package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class PhotoListCustomizationWink extends PhotoListCustomizationDefault implements e {
    static IPatchRedirector $redirector_;
    public static final String H;
    private View F;
    private View G;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68952);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            H = PhotoListCustomizationWink.class.getName();
        }
    }

    public PhotoListCustomizationWink(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.I();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void T() {
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.T();
        if (this.F == null) {
            return;
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        if (photoCommonBaseData != 0 && (arrayList = photoCommonBaseData.selectedPhotoList) != null && !arrayList.isEmpty()) {
            this.F.setClickable(true);
            this.F.setBackgroundResource(R.drawable.f161103k22);
        } else {
            this.F.setClickable(false);
            this.F.setBackgroundResource(R.drawable.f161106k25);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.b
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.D.getSystemService("layout_inflater");
        View view = null;
        if (layoutInflater != null) {
            view = layoutInflater.inflate(R.layout.fes, (ViewGroup) null);
            View findViewById = view.findViewById(R.id.f124187io);
            this.G = findViewById;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationWink.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationWink.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    EventCollector.getInstance().onViewClickedBefore(view2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2);
                    } else {
                        ((PhotoListCustomizationDefault) PhotoListCustomizationWink.this).D.getIntent().putExtra("skipSelect", 1);
                        PhotoListCustomizationWink.this.C0();
                    }
                    EventCollector.getInstance().onViewClicked(view2);
                }
            });
            View findViewById2 = view.findViewById(R.id.f124177in);
            this.F = findViewById2;
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationWink.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationWink.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    EventCollector.getInstance().onViewClickedBefore(view2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2);
                    } else {
                        ((PhotoListCustomizationDefault) PhotoListCustomizationWink.this).D.getIntent().putExtra("skipSelect", 0);
                        PhotoListCustomizationWink.this.C0();
                    }
                    EventCollector.getInstance().onViewClicked(view2);
                }
            });
        }
        if (view != null) {
            return view;
        }
        return super.d();
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void i(SlideItemInfo slideItemInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) slideItemInfo);
        }
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void n(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
    }
}
