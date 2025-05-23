package com.tencent.tbs.reader;

import android.content.Context;
import com.tencent.tbs.reader.external.ITbsReaderEditAtom;
import com.tencent.tbs.reader.external.TbsReaderAdvAtom;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TbsReaderEditManager extends TbsReaderManager {
    public static final String TAG = "TbsReaderManager";
    private TbsReaderAdvAtom mReaderAdvAtom = null;

    @Override // com.tencent.tbs.reader.TbsReaderManager
    public void destroy() {
        super.destroy();
        TbsReaderAdvAtom tbsReaderAdvAtom = this.mReaderAdvAtom;
        if (tbsReaderAdvAtom != null) {
            tbsReaderAdvAtom.destory();
        }
        this.mReaderAdvAtom = null;
    }

    public TbsReaderAdvAtom getEditAtom() {
        return this.mReaderAdvAtom;
    }

    @Override // com.tencent.tbs.reader.TbsReaderManager
    public boolean initReader(Context context, ITbsReaderCallback iTbsReaderCallback) {
        this.mReaderCore = createReaderCore(context, iTbsReaderCallback, 1);
        ITbsReader iTbsReader = this.mReader;
        if (iTbsReader != null) {
            this.mReaderAdvAtom = new TbsReaderAdvAtom((ITbsReaderEditAtom) iTbsReader.createAtom(2));
        }
        TbsReaderCore tbsReaderCore = this.mReaderCore;
        if (tbsReaderCore != null && tbsReaderCore.init(context)) {
            return true;
        }
        return false;
    }
}
