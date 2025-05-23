package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/* loaded from: classes12.dex */
public class PreviewThumbAdapter extends BaseAdapter implements AdapterView.OnItemClickListener, IPreviewThumbAdapter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PreviewThumbAdapter";
    private ColorDrawable colorDrawable;
    private String currentPath;
    private Context mContext;
    private Drawable mDefaultPhotoDrawable;
    private ArrayList<String> mSelectedPaths;
    private IPreviewThumbAdapter.IThumbItemClickListener thumbItemClickListener;
    private int thumbWidth;

    /* loaded from: classes12.dex */
    public class Holder {
        static IPatchRedirector $redirector_;
        public URLDrawable mDrawable;
        public URLImageView mImageView;
        public ImageView mSelectView;

        public Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreviewThumbAdapter.this);
            }
        }
    }

    public PreviewThumbAdapter(Context context, IPreviewThumbAdapter.IThumbItemClickListener iThumbItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) iThumbItemClickListener);
            return;
        }
        this.mSelectedPaths = new ArrayList<>();
        this.mContext = context;
        this.thumbItemClickListener = iThumbItemClickListener;
        this.colorDrawable = new ColorDrawable(570425344);
        this.mDefaultPhotoDrawable = this.mContext.getResources().getDrawable(R.drawable.asd);
        this.thumbWidth = com.tencent.mobileqq.EmotionUtils.a(50.0f, this.mContext.getResources());
    }

    public static URL generateAlbumThumbPreviewURL(String str, String str2) {
        StringBuilder sb5 = new StringBuilder(ProtocolDownloaderConstants.PROTOCOL_ALBUM_THUMB_PREVIEW);
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb5.append(str);
        if (str2 != null) {
            sb5.append("#");
            sb5.append(str2);
        }
        try {
            return new URL(sb5.toString());
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage(), e16);
                return null;
            }
            return null;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        ArrayList<String> arrayList = this.mSelectedPaths;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter
    public String getCurrentPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.currentPath;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter
    public ArrayList<String> getDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mSelectedPaths;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, i3)).longValue();
        }
        return i3;
    }

    public LocalMediaInfo getMediaInfoTemp(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.mMediaType = 0;
        localMediaInfo.path = str;
        int i3 = this.thumbWidth;
        localMediaInfo.thumbWidth = i3;
        localMediaInfo.thumbHeight = i3;
        return localMediaInfo;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        Holder holder;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            view2 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                Holder holder2 = new Holder();
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.h8l, viewGroup, false);
                holder2.mImageView = (URLImageView) inflate.findViewById(R.id.ma_);
                holder2.mSelectView = (ImageView) inflate.findViewById(R.id.ma9);
                inflate.setTag(holder2);
                holder = holder2;
                view = inflate;
            } else {
                holder = (Holder) view.getTag();
            }
            String item = getItem(i3);
            if (!TextUtils.isEmpty(item)) {
                if (item.equals(this.currentPath)) {
                    holder.mSelectView.setVisibility(0);
                } else {
                    holder.mSelectView.setVisibility(8);
                }
                LocalMediaInfo mediaInfoTemp = getMediaInfoTemp(item);
                URL generateAlbumThumbPreviewURL = generateAlbumThumbPreviewURL(item, "DEFAULT");
                URLDrawable uRLDrawable = holder.mDrawable;
                if (generateAlbumThumbPreviewURL != null && (uRLDrawable == null || !uRLDrawable.getURL().toString().equals(generateAlbumThumbPreviewURL.toString()))) {
                    URLDrawable drawable = ((IEmosmService) QRoute.api(IEmosmService.class)).getDrawable(generateAlbumThumbPreviewURL, this.colorDrawable, this.mDefaultPhotoDrawable);
                    drawable.setTag(mediaInfoTemp);
                    holder.mImageView.setImageDrawable(drawable);
                    holder.mDrawable = drawable;
                }
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            IPreviewThumbAdapter.IThumbItemClickListener iThumbItemClickListener = this.thumbItemClickListener;
            if (iThumbItemClickListener != null) {
                iThumbItemClickListener.onThumbClick(i3);
            }
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @Override // com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter
    public void setCurrentPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.currentPath = str;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter
    public void setData(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
        } else {
            this.mSelectedPaths = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public String getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        ArrayList<String> arrayList = this.mSelectedPaths;
        if (arrayList == null || i3 >= arrayList.size()) {
            return null;
        }
        return this.mSelectedPaths.get(i3);
    }
}
