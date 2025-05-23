package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import android.content.Context;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;
import ob1.a;
import ob1.d;
import ob1.e;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileDelDownloadAdapter extends e implements View.OnClickListener {
    LinkedHashMap<String, List<FileInfo>> P;
    int Q;
    private final String R;
    private final String S;
    private final int T;
    private final int U;

    public QFileDelDownloadAdapter(BaseFileAssistantActivity baseFileAssistantActivity, Object obj, int i3) {
        super(baseFileAssistantActivity, obj, null, null, null, null, null);
        this.P = null;
        this.Q = -1;
        this.P = (LinkedHashMap) obj;
        this.Q = i3;
        this.R = baseFileAssistantActivity.getString(R.string.b7q);
        this.S = baseFileAssistantActivity.getString(R.string.b7r);
        this.T = (int) al.a(BaseApplication.getContext(), 5.0f);
        this.U = (int) al.a(BaseApplication.getContext(), 24.0f);
    }

    private void q(final View view, final int i3, final int i16, final int i17, final int i18) {
        ((View) view.getParent()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.delDownloadFile.QFileDelDownloadAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                view.setEnabled(true);
                view.getHitRect(rect);
                rect.top -= i3;
                rect.bottom += i16;
                rect.left -= i17;
                rect.right += i18;
                ((View) view.getParent()).setTouchDelegate(new TouchDelegate(rect, view));
            }
        });
    }

    @Override // ob1.d, com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        super.configHeaderView(view, i3);
        d.e eVar = (d.e) view.getTag();
        if (eVar != null) {
            if (this.E.Y2() == 1) {
                view.setEnabled(false);
                i(eVar, false);
            } else {
                view.setEnabled(true);
                i(eVar, true);
            }
        }
    }

    @Override // ob1.d, android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        d.e eVar;
        View groupView = super.getGroupView(i3, z16, view, viewGroup);
        if (groupView != null) {
            eVar = (d.e) groupView.getTag();
        } else {
            eVar = null;
        }
        if (eVar != null) {
            if (this.E.Y2() == 1) {
                groupView.setEnabled(false);
                onGroupExpanded(0);
                i(eVar, false);
            } else {
                groupView.setEnabled(true);
                i(eVar, true);
            }
        }
        return groupView;
    }

    @Override // ob1.e
    protected int k() {
        return 4;
    }

    @Override // ob1.e
    protected View n(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        FileInfo fileInfo;
        a aVar;
        Object child = getChild(i3, i16);
        if (child != null) {
            fileInfo = (FileInfo) child;
        } else {
            fileInfo = null;
        }
        if (fileInfo == null) {
            return null;
        }
        try {
            if (view == null) {
                view = this.F.inflate(R.layout.alv, (ViewGroup) null);
                aVar = new a();
                aVar.f422312a = (AsyncImageView) view.findViewById(R.id.image);
                aVar.f422313b = (CheckBox) view.findViewById(R.id.awy);
                aVar.f422314c = (ImageView) view.findViewById(R.id.dc6);
                aVar.f422315d = (EllipsizingTextView) view.findViewById(R.id.c_g);
                aVar.f422316e = (TextView) view.findViewById(R.id.c_j);
                CheckBox checkBox = aVar.f422313b;
                int i17 = this.T;
                int i18 = this.U;
                q(checkBox, i17, i18, i18, i17);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            fileInfo.u((String) getGroup(i3));
            aVar.f422317f = fileInfo;
            aVar.f422318g = i16;
            aVar.f422319h = i3;
            aVar.f422312a.setAdjustViewBounds(false);
            aVar.f422312a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            aVar.f422312a.setDefaultImage(R.drawable.asd);
            AsyncImageView asyncImageView = aVar.f422312a;
            int i19 = this.L;
            asyncImageView.setAsyncClipSize(i19, i19);
            if (!fileInfo.n()) {
                aVar.f422315d.setText(fileInfo.j());
                aVar.f422315d.setMaxLines(2);
            } else {
                aVar.f422315d.setText((CharSequence) null);
            }
            aVar.f422316e.setText(FileCategoryUtil.f(fileInfo.l()));
            view.setOnClickListener(this);
            aVar.f422313b.setOnClickListener(this);
            aVar.f422313b.setTag(aVar);
            d.InterfaceC10897d interfaceC10897d = this.f422339f;
            if (interfaceC10897d != null) {
                String g16 = interfaceC10897d.g(fileInfo);
                if (FileUtils.fileExistsAndNotEmpty(g16)) {
                    aVar.f422312a.setAsyncImage(g16);
                }
            }
            String str = this.R + fileInfo.j();
            aVar.f422313b.setVisibility(0);
            if (f.C(fileInfo)) {
                str = str + this.S;
                aVar.f422313b.setChecked(true);
                aVar.f422313b.setButtonDrawable(R.drawable.list_checkbox_selected);
                view.setBackgroundColor(this.E.getResources().getColor(R.color.f158017al3));
                aVar.f422314c.setVisibility(0);
                view.setOnLongClickListener(null);
            } else {
                aVar.f422314c.setVisibility(4);
                aVar.f422313b.setChecked(false);
                aVar.f422313b.setButtonDrawable(R.drawable.qq_pic_img_checkbox_deselect);
            }
            aVar.f422312a.setContentDescription(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("#######", 1, e16.toString());
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        a aVar = (a) view.getTag();
        if (id5 == R.id.awy) {
            if (f.C(aVar.f422317f)) {
                f.G(aVar.f422317f);
                aVar.f422313b.setChecked(false);
                aVar.f422313b.setButtonDrawable(R.drawable.qq_pic_img_checkbox_deselect);
                aVar.f422314c.setVisibility(4);
                d.InterfaceC10897d interfaceC10897d = this.f422339f;
                if (interfaceC10897d != null) {
                    interfaceC10897d.a(aVar.f422317f, false);
                }
            } else {
                f.c(aVar.f422317f);
                aVar.f422313b.setChecked(true);
                aVar.f422313b.setButtonDrawable(R.drawable.list_checkbox_selected);
                aVar.f422314c.setVisibility(0);
                d.InterfaceC10897d interfaceC10897d2 = this.f422339f;
                if (interfaceC10897d2 != null) {
                    interfaceC10897d2.a(aVar.f422317f, true);
                }
            }
            this.E.I2();
        } else if (this.f422339f != null) {
            IQQFileTempUtils iQQFileTempUtils = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
            Context context = this.C;
            FileInfo fileInfo = aVar.f422317f;
            iQQFileTempUtils.openFileBrowserByFileInfo(context, fileInfo, this.Q, this.f422339f.g(fileInfo), view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
