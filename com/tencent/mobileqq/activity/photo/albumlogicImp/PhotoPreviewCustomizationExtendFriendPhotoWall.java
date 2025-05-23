package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationExtendFriendPhotoWall extends PhotoPreviewCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String G;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68968);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            G = PhotoPreviewCustomizationExtendFriendPhotoWall.class.getName();
        }
    }

    protected PhotoPreviewCustomizationExtendFriendPhotoWall(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ArrayList<String> arrayList = this.f184334e.selectedPhotoList;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.a();
            v().H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationExtendFriendPhotoWall.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationExtendFriendPhotoWall.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        Intent intent = new Intent();
                        int i3 = PhotoPreviewCustomizationExtendFriendPhotoWall.this.v().i();
                        ArrayList<String> arrayList = PhotoPreviewCustomizationExtendFriendPhotoWall.this.f184334e.selectedPhotoList;
                        if (arrayList != null && arrayList.size() != 0) {
                            intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", PhotoPreviewCustomizationExtendFriendPhotoWall.this.f184334e.selectedPhotoList);
                        } else if (((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationExtendFriendPhotoWall.this).C.f184324b != null && i3 != -1) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String str = ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationExtendFriendPhotoWall.this).C.f184324b.get(i3);
                            if (!TextUtils.isEmpty(str)) {
                                arrayList2.add(str);
                                intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", arrayList2);
                            } else {
                                QLog.d("PhotoPreviewCustomizationExtendFriendPhotoWall", 1, "sendBtn click currentPath is null");
                            }
                        }
                        ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationExtendFriendPhotoWall.this).f184197m.setResult(-1, intent);
                        ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationExtendFriendPhotoWall.this).f184197m.finish();
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }
}
