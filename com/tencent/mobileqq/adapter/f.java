package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatHistoryViewBase;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private LayoutInflater C;
    private b D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private final String f187161d;

    /* renamed from: e, reason: collision with root package name */
    private View.OnClickListener f187162e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f187163f;

    /* renamed from: h, reason: collision with root package name */
    private List<Object> f187164h;

    /* renamed from: i, reason: collision with root package name */
    private Context f187165i;

    /* renamed from: m, reason: collision with root package name */
    private ChatHistoryViewBase f187166m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements Cloneable {
        static IPatchRedirector $redirector_;
        public TextView C;
        public Object D;

        /* renamed from: d, reason: collision with root package name */
        public RelativeLayout f187167d;

        /* renamed from: e, reason: collision with root package name */
        public CircleFileStateView f187168e;

        /* renamed from: f, reason: collision with root package name */
        public int f187169f;

        /* renamed from: h, reason: collision with root package name */
        public CheckBox f187170h;

        /* renamed from: i, reason: collision with root package name */
        public AsyncImageView f187171i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f187172m;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        boolean isSelected(FileManagerEntity fileManagerEntity);
    }

    public f(Context context, List<Object> list, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, ChatHistoryViewBase chatHistoryViewBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, list, onClickListener, onClickListener2, chatHistoryViewBase);
            return;
        }
        this.f187161d = "ChatHistoryFileAdapter";
        this.E = false;
        this.f187165i = context;
        this.f187164h = list;
        this.f187162e = onClickListener;
        this.f187163f = onClickListener2;
        this.f187166m = chatHistoryViewBase;
        this.C = LayoutInflater.from(context);
    }

    public void a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.D = bVar;
        }
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.E = z16;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        List<Object> list = this.f187164h;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.f187164h.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01f4 A[Catch: Exception -> 0x021c, TryCatch #0 {Exception -> 0x021c, blocks: (B:21:0x0030, B:23:0x0034, B:25:0x003c, B:26:0x00be, B:28:0x00f0, B:30:0x00fa, B:31:0x012d, B:33:0x0138, B:34:0x013b, B:36:0x0143, B:37:0x0146, B:38:0x01f0, B:40:0x01f4, B:42:0x0207, B:43:0x020b, B:44:0x0216, B:46:0x0211, B:47:0x014d, B:48:0x015b, B:49:0x0169, B:50:0x0172, B:51:0x017b, B:52:0x0184, B:53:0x0191, B:54:0x019e, B:56:0x01ac, B:60:0x01b5, B:61:0x01c2, B:62:0x01ca, B:63:0x01d7, B:64:0x01e4, B:65:0x0106, B:67:0x010e, B:68:0x011e, B:69:0x0128, B:70:0x0043), top: B:20:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0211 A[Catch: Exception -> 0x021c, TryCatch #0 {Exception -> 0x021c, blocks: (B:21:0x0030, B:23:0x0034, B:25:0x003c, B:26:0x00be, B:28:0x00f0, B:30:0x00fa, B:31:0x012d, B:33:0x0138, B:34:0x013b, B:36:0x0143, B:37:0x0146, B:38:0x01f0, B:40:0x01f4, B:42:0x0207, B:43:0x020b, B:44:0x0216, B:46:0x0211, B:47:0x014d, B:48:0x015b, B:49:0x0169, B:50:0x0172, B:51:0x017b, B:52:0x0184, B:53:0x0191, B:54:0x019e, B:56:0x01ac, B:60:0x01b5, B:61:0x01c2, B:62:0x01ca, B:63:0x01d7, B:64:0x01e4, B:65:0x0106, B:67:0x010e, B:68:0x011e, B:69:0x0128, B:70:0x0043), top: B:20:0x0030 }] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = view;
            view = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            Object item = getItem(i3);
            if (item instanceof FileManagerEntity) {
                try {
                    FileManagerEntity fileManagerEntity = (FileManagerEntity) item;
                    if (view != null && (view.getTag() instanceof a)) {
                        aVar = (a) view.getTag();
                    } else {
                        aVar = new a();
                        view = this.C.inflate(R.layout.alg, viewGroup, false);
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.i0x);
                        aVar.f187167d = relativeLayout;
                        relativeLayout.setOnClickListener(this.f187162e);
                        aVar.f187167d.setTag(aVar);
                        aVar.f187168e = (CircleFileStateView) view.findViewById(R.id.f163908c1);
                        aVar.f187170h = (CheckBox) view.findViewById(R.id.c_i);
                        aVar.f187171i = (AsyncImageView) view.findViewById(R.id.c_5);
                        TextView textView2 = (TextView) view.findViewById(R.id.c_g);
                        aVar.f187172m = textView2;
                        textView2.setMaxLines(2);
                        aVar.C = (TextView) view.findViewById(R.id.c_3);
                        aVar.f187171i.setAsyncClipSize(BaseAIOUtils.f(70.0f, this.f187165i.getResources()), BaseAIOUtils.f(70.0f, this.f187165i.getResources()));
                        view.setTag(aVar);
                    }
                    FileManagerUtil.setFileIcon(aVar.f187171i, fileManagerEntity);
                    aVar.f187167d.setVisibility(0);
                    aVar.D = fileManagerEntity;
                    aVar.f187168e.setOnClickListener(this.f187163f);
                    aVar.f187168e.setTag(aVar);
                    aVar.f187168e.setProgress((int) (fileManagerEntity.fProgress * 100.0f));
                    aVar.f187168e.setProgressRingWidth(3.0f);
                    if (FileManagerUtil.getFileType(fileManagerEntity.fileName) == 0) {
                        if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
                            FileManagerUtil.setFileIcon(aVar.f187171i, fileManagerEntity.getFilePath(), fileManagerEntity.nFileType);
                        } else if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strThumbPath)) {
                            aVar.f187171i.setDefaultImage(R.drawable.e9y);
                            aVar.f187171i.setAsyncImage(fileManagerEntity.strThumbPath);
                        } else {
                            FileManagerUtil.setFileIcon(aVar.f187171i, fileManagerEntity.fileName, fileManagerEntity.nFileType);
                        }
                    } else {
                        FileManagerUtil.setFileIcon(aVar.f187171i, fileManagerEntity);
                    }
                    aVar.f187172m.setText(fileManagerEntity.fileName);
                    if (5 != fileManagerEntity.cloudType) {
                        FileManagerUtil.associateLocalWithCloud(fileManagerEntity);
                    }
                    int i16 = fileManagerEntity.status;
                    if (i16 != 18) {
                        switch (i16) {
                            case -1:
                                aVar.f187168e.setState(2);
                                aVar.f187168e.setVisibility(0);
                                aVar.f187169f = 1;
                                break;
                            case 0:
                                aVar.f187168e.setState(2);
                                aVar.f187168e.setVisibility(0);
                                aVar.f187169f = 3;
                                break;
                            case 1:
                                boolean p16 = com.tencent.mobileqq.filemanager.util.q.p(fileManagerEntity.getFilePath());
                                if (fileManagerEntity.getCloudType() != 3 && fileManagerEntity.getCloudType() != 5 && !p16) {
                                    aVar.f187168e.setState(2);
                                    aVar.f187168e.setVisibility(0);
                                    aVar.f187169f = 1;
                                    break;
                                }
                                aVar.f187168e.setVisibility(8);
                                aVar.f187169f = 0;
                                break;
                            case 2:
                                break;
                            case 3:
                                aVar.f187168e.setState(2);
                                aVar.f187168e.setVisibility(0);
                                aVar.f187169f = 3;
                                break;
                            case 4:
                                aVar.f187168e.setState(2);
                                aVar.f187169f = 1;
                                aVar.f187168e.setVisibility(0);
                                break;
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                aVar.f187168e.setVisibility(8);
                                aVar.f187169f = 0;
                                break;
                            case 9:
                            case 12:
                                aVar.f187168e.setVisibility(8);
                                aVar.f187169f = 0;
                                break;
                            case 10:
                            case 11:
                                aVar.f187168e.setVisibility(8);
                                aVar.f187169f = 0;
                                break;
                            case 13:
                                aVar.f187168e.setState(2);
                                aVar.f187168e.setVisibility(0);
                                aVar.f187169f = 1;
                                break;
                            case 14:
                            case 15:
                                aVar.f187168e.setState(2);
                                aVar.f187168e.setVisibility(8);
                                aVar.f187169f = 2;
                                break;
                            default:
                                aVar.f187168e.setVisibility(8);
                                break;
                        }
                        if (!this.E) {
                            aVar.f187168e.setVisibility(8);
                            aVar.f187170h.setVisibility(8);
                            aVar.f187170h.setVisibility(0);
                            b bVar = this.D;
                            if (bVar != null) {
                                z16 = bVar.isSelected(fileManagerEntity);
                            }
                            aVar.f187170h.setChecked(z16);
                        } else {
                            aVar.f187170h.setVisibility(8);
                        }
                        FileManagerUtil.calcFileDescription(aVar.C, fileManagerEntity);
                    }
                    aVar.f187168e.setState(1);
                    aVar.f187168e.setVisibility(0);
                    aVar.f187169f = 2;
                    if (!this.E) {
                    }
                    FileManagerUtil.calcFileDescription(aVar.C, fileManagerEntity);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else if (item instanceof String) {
                if (view != null && (view.getTag() instanceof TextView)) {
                    textView = (TextView) view.getTag();
                } else {
                    view = View.inflate(this.f187165i, R.layout.f168647am3, null);
                    textView = (TextView) view.findViewById(R.id.jfo);
                    view.setTag(textView);
                }
                textView.setText((String) item);
            }
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }
}
