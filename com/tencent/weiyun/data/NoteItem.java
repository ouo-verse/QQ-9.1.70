package com.tencent.weiyun.data;

import android.text.TextUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NoteItem extends CNativeObject {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_ARTICLE = 1;
    public static final int TYPE_COLLECTION = 4;
    public static final int TYPE_HTML_TEXT = 2;
    public static final int TYPE_MAIL = 3;
    public ArticleText articleText;
    public long createTime;
    public HtmlText htmlText;
    public boolean isDeleted;
    public String md5;
    public long modifyTime;
    private String noteId;
    public String noteSummary;
    public String noteTitle;
    public int noteType;
    public boolean starFlag;
    public long starTime;
    public String thumbUrl;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ArticleText extends CNativeObject {
        static IPatchRedirector $redirector_;
        public HtmlText articleComment;
        public String articleContent;
        public String articlePicsUrl;
        public String articleRawUrl;
        public String articleThumbId;
        public String articleTitle;
        public String articleUrl;

        ArticleText() {
            super(0L);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public static ArticleText newInstance(long j3) {
            if (j3 == 0) {
                return null;
            }
            ArticleText articleText = new ArticleText(j3);
            articleText.articleRawUrl = CBundleReader.getString(j3, "article_raw_url");
            articleText.articleTitle = CBundleReader.getString(j3, "article_title");
            articleText.articleUrl = CBundleReader.getString(j3, "article_url");
            articleText.articlePicsUrl = CBundleReader.getString(j3, "article_pics_url");
            articleText.articleThumbId = CBundleReader.getString(j3, "article_thumb_id");
            articleText.articleContent = CBundleReader.getString(j3, "article_content");
            long j16 = CBundleReader.getLong(j3, "article_comment", 0L);
            if (j16 != 0) {
                articleText.articleComment = HtmlText.newInstance(j16);
            }
            articleText.releaseNative();
            return articleText;
        }

        @Override // com.tencent.weiyun.data.CNativeObject
        public void releaseNative() {
            HtmlText htmlText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (isNative() && (htmlText = this.articleComment) != null) {
                htmlText.releaseNative();
            }
            super.releaseNative();
        }

        ArticleText(long j3) {
            super(j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class HtmlText extends CNativeObject {
        static IPatchRedirector $redirector_;
        public FileItem[] fileList;
        public String htmlContent;
        public String[] picUrlList;

        HtmlText() {
            super(0L);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public static HtmlText newInstance(long j3) {
            FileItem newInstance;
            if (j3 == 0) {
                return null;
            }
            HtmlText htmlText = new HtmlText(j3);
            htmlText.htmlContent = CBundleReader.getString(j3, "html_content");
            long[] longArray = CBundleReader.getLongArray(j3, "pic_url_list");
            if (longArray != null) {
                ArrayList arrayList = new ArrayList(longArray.length);
                for (long j16 : longArray) {
                    if (j16 != 0) {
                        String string = CBundleReader.getString(j16, "url");
                        if (!TextUtils.isEmpty(string)) {
                            arrayList.add(string);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    htmlText.picUrlList = (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
            }
            long[] longArray2 = CBundleReader.getLongArray(j3, "file_list");
            if (longArray2 != null) {
                ArrayList arrayList2 = new ArrayList(longArray2.length);
                for (long j17 : longArray2) {
                    if (j17 != 0 && (newInstance = FileItem.newInstance(j17)) != null) {
                        arrayList2.add(newInstance);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    htmlText.fileList = (FileItem[]) arrayList2.toArray(new FileItem[arrayList2.size()]);
                }
            }
            htmlText.releaseNative();
            return htmlText;
        }

        @Override // com.tencent.weiyun.data.CNativeObject
        public void releaseNative() {
            FileItem[] fileItemArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (isNative() && (fileItemArr = this.fileList) != null) {
                for (FileItem fileItem : fileItemArr) {
                    if (fileItem != null) {
                        fileItem.releaseNative();
                    }
                }
            }
            super.releaseNative();
        }

        HtmlText(long j3) {
            super(j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
    }

    NoteItem() {
        super(0L);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.isDeleted = false;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static NoteItem newInstance(long j3) {
        if (j3 == 0) {
            return null;
        }
        NoteItem noteItem = new NoteItem(j3);
        noteItem.noteId = CBundleReader.getString(j3, "note_id");
        noteItem.noteType = CBundleReader.getInt(j3, "note_type", 0);
        noteItem.noteTitle = CBundleReader.getString(j3, "note_title");
        noteItem.noteSummary = CBundleReader.getString(j3, "note_summary");
        noteItem.createTime = CBundleReader.getLong(j3, AlbumCacheData.CREATE_TIME, 0L);
        noteItem.modifyTime = CBundleReader.getLong(j3, "modify_time", 0L);
        noteItem.thumbUrl = CBundleReader.getString(j3, FacadeCacheData.THUMB_URL);
        noteItem.md5 = CBundleReader.getHexString(j3, "md5").toLowerCase();
        noteItem.starTime = CBundleReader.getLong(j3, "star_time", 0L);
        noteItem.starFlag = CBundleReader.getBoolean(j3, "star_flag", false);
        noteItem.isDeleted = CBundleReader.getBoolean(j3, PictureConst.PHOTO_DELETED, false);
        long j16 = CBundleReader.getLong(j3, "article_text", 0L);
        if (j16 != 0) {
            noteItem.articleText = ArticleText.newInstance(j16);
        }
        long j17 = CBundleReader.getLong(j3, "html_text", 0L);
        if (j17 != 0) {
            noteItem.htmlText = HtmlText.newInstance(j17);
        }
        noteItem.releaseNative();
        return noteItem;
    }

    public String noteId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.noteId;
    }

    @Override // com.tencent.weiyun.data.CNativeObject
    public void releaseNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (isNative()) {
            ArticleText articleText = this.articleText;
            if (articleText != null) {
                articleText.releaseNative();
            }
            HtmlText htmlText = this.htmlText;
            if (htmlText != null) {
                htmlText.releaseNative();
            }
        }
        super.releaseNative();
    }

    NoteItem(long j3) {
        super(j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.isDeleted = false;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
    }
}
