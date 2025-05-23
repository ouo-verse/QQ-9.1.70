package com.tencent.mobileqq.filemanager.data.search;

import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URL;
import java.util.List;
import qn2.f;

/* loaded from: classes12.dex */
public class FileSearchResultPresenter extends f {

    /* renamed from: e, reason: collision with root package name */
    private BitmapFactory.Options f207884e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f207885f;

    public FileSearchResultPresenter(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
        this.f207885f = false;
        this.f207884e = new BitmapFactory.Options();
    }

    private void n(final sn2.c cVar, final FileManagerEntity fileManagerEntity) {
        final ImageView f16 = cVar.f();
        f16.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Object tag = f16.getTag(R.id.v5d);
        if (tag != null && ((Long) tag).longValue() == fileManagerEntity.uniseq) {
            if (f16.getDrawable() == null) {
                FileManagerUtil.setFileIcon(f16, fileManagerEntity);
            }
        } else {
            f16.setImageDrawable(null);
            f16.setBackgroundDrawable(null);
            FileManagerUtil.setFileIcon(f16, fileManagerEntity);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.FileSearchResultPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                int fileType = FileManagerUtil.getFileType(fileManagerEntity.fileName);
                URL d16 = FilePicURLDrawlableHelper.d(fileManagerEntity);
                if (d16 == null && fileType == 2) {
                    d16 = FilePicURLDrawlableHelper.c(fileManagerEntity);
                }
                if (d16 != null) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestHeight = cVar.f().getHeight();
                    obtain.mRequestWidth = cVar.f().getWidth();
                    final URLDrawable drawable = URLDrawable.getDrawable(d16, obtain);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.FileSearchResultPresenter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Object tag2 = f16.getTag(R.id.v5d);
                            if (tag2 != null) {
                                long longValue = ((Long) tag2).longValue();
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                FileManagerEntity fileManagerEntity2 = fileManagerEntity;
                                if (longValue == fileManagerEntity2.uniseq) {
                                    URLDrawable uRLDrawable = drawable;
                                    if (uRLDrawable == null) {
                                        FileManagerUtil.setFileIcon(f16, fileManagerEntity2);
                                    } else {
                                        f16.setImageDrawable(uRLDrawable);
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }, 64, null, true);
    }

    @Override // qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        super.a(yVar, cVar);
        if (cVar.b() != null && !TextUtils.isEmpty(yVar.u())) {
            cVar.b().setVisibility(0);
            cVar.b().setText(yVar.u());
        }
        if (cVar.c() != null && !TextUtils.isEmpty(yVar.t())) {
            cVar.c().setVisibility(0);
            cVar.c().setText(yVar.t());
        }
        if (cVar.k() != null && !TextUtils.isEmpty(yVar.m())) {
            cVar.k().setVisibility(0);
            cVar.k().setText(yVar.m());
        }
        if (yVar.o() == null && cVar.d() != null) {
            cVar.d().setVisibility(8);
        }
        if (cVar.d() != null && yVar.o() != null) {
            cVar.d().setVisibility(0);
            cVar.d().setText(yVar.o());
        }
        if (cVar instanceof FileSearchResultView) {
            ((FileSearchResultView) cVar).y(yVar);
        }
    }

    @Override // qn2.f, qn2.c
    /* renamed from: i */
    public void c(y yVar, sn2.c cVar) {
        String str;
        cVar.b().setMaxWidth(800);
        c cVar2 = (c) yVar;
        cVar2.M = this.f207885f;
        ImageView f16 = cVar.f();
        List<FileManagerEntity> list = cVar2.G;
        if (list == null) {
            return;
        }
        FileManagerEntity fileManagerEntity = list.get(0);
        int fileType = FileManagerUtil.getFileType(fileManagerEntity.fileName);
        if (fileManagerEntity.searchPCPart.f207687c) {
            fileType = 22;
        }
        if (fileType != 0 && fileType != 2) {
            FileManagerUtil.setFileIcon(f16, fileManagerEntity);
        } else {
            if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strThumbPath)) {
                f16.setImageDrawable(Drawable.createFromPath(fileManagerEntity.strThumbPath));
                f16.setTag(R.id.v5d, Long.valueOf(fileManagerEntity.uniseq));
                return;
            }
            if (!FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strLargeThumPath)) {
                if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
                    fileManagerEntity.getFilePath();
                } else {
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                    if (fileManagerEntity.getCloudType() == 1) {
                        str = qQAppInterface.getFileManagerEngine().m(fileManagerEntity, 7);
                    } else if (fileManagerEntity.getCloudType() == 2) {
                        str = qQAppInterface.getFileManagerEngine().Z(fileManagerEntity.WeiYunFileId, fileManagerEntity.strLargeThumPath, 3, fileManagerEntity);
                    } else {
                        str = "";
                    }
                    if (TextUtils.isEmpty(str)) {
                        f16.setImageDrawable(BaseApplication.getContext().getResources().getDrawable(R.drawable.e9y));
                        return;
                    }
                    fileManagerEntity.strThumbPath = str;
                }
            }
            n(cVar, fileManagerEntity);
        }
        f16.setTag(R.id.v5d, Long.valueOf(fileManagerEntity.uniseq));
    }
}
