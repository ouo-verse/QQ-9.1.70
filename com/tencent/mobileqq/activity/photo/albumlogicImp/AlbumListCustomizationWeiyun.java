package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weiyun.utils.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumListCustomizationWeiyun extends AlbumListCustomizationDefault {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static final String f184375k;

    /* renamed from: j, reason: collision with root package name */
    private List<String> f184376j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68905);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f184375k = AlbumListCustomizationWeiyun.class.getName();
        }
    }

    AlbumListCustomizationWeiyun(AbstractAlbumListFragment abstractAlbumListFragment) {
        super(abstractAlbumListFragment);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractAlbumListFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b.InterfaceC7191b
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            super.b(-1);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b
    public void f(Intent intent) {
        List<String> j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        if (intent.getIntExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 0) == 5) {
            intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 6);
        }
        super.f(intent);
        this.f184222b.albumName = intent.getStringExtra(QAlbumConstants.ALBUM_NAME);
        AlbumListFragment albumListFragment = this.f184171i;
        if (albumListFragment.isAdded() && !albumListFragment.isDetached() && !albumListFragment.isRemoving()) {
            String a16 = c.a(albumListFragment.getActivity().getApplicationContext(), ((h) this.f184223c).f184249h, "pref_select_album");
            if (TextUtils.isEmpty(a16)) {
                j3 = new ArrayList<>();
            } else {
                j3 = c.j(a16);
            }
            this.f184376j = j3;
            if (j3 != null && !j3.isEmpty()) {
                this.f184222b.albumId = this.f184376j.get(0);
            }
            if (TextUtils.isEmpty(this.f184222b.albumId)) {
                this.f184222b.albumId = QAlbumCustomAlbumConstants.RECENT_ALBUM_ID;
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b
    public boolean g(QQAlbumInfo qQAlbumInfo, int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, qQAlbumInfo, Integer.valueOf(i3), intent)).booleanValue();
        }
        boolean g16 = super.g(qQAlbumInfo, i3, intent);
        if (!TextUtils.isEmpty(this.f184222b.albumName)) {
            intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184222b.albumName);
        }
        AlbumListFragment albumListFragment = this.f184171i;
        if (albumListFragment != null && albumListFragment.isAdded() && !albumListFragment.isDetached() && !albumListFragment.isRemoving() && this.f184376j != null) {
            if (!TextUtils.isEmpty(qQAlbumInfo.f203112id)) {
                if (this.f184376j.contains(qQAlbumInfo.f203112id) && !TextUtils.equals(qQAlbumInfo.f203112id, this.f184376j.get(0))) {
                    this.f184376j.remove(qQAlbumInfo.f203112id);
                }
                if (this.f184376j.isEmpty()) {
                    this.f184376j.add(qQAlbumInfo.f203112id);
                } else {
                    this.f184376j.set(0, qQAlbumInfo.f203112id);
                }
            }
            c.i(albumListFragment.getActivity().getApplicationContext(), ((h) this.f184223c).f184249h, "pref_select_album", c.g(this.f184376j.iterator()));
        }
        return g16;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b.InterfaceC7191b
    public View getView(int i3, View view, ViewGroup viewGroup) {
        AlbumListAdapter albumListAdapter;
        QQAlbumInfo item;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
        }
        View view2 = super.getView(i3, view, viewGroup);
        AlbumListFragment albumListFragment = this.f184171i;
        if (albumListFragment != null && albumListFragment.isAdded() && !albumListFragment.isDetached() && !albumListFragment.isRemoving() && (albumListAdapter = albumListFragment.D) != null && (item = albumListAdapter.getItem(i3)) != null && (view2 instanceof TextView)) {
            ((TextView) view2).setText(item.name);
        }
        return view2;
    }
}
