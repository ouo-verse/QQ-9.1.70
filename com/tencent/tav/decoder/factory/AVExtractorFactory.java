package com.tencent.tav.decoder.factory;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.tav.decoder.extractor.FfmpegExtractorCreator;
import com.tencent.tav.decoder.extractor.IExtractor;
import com.tencent.tav.decoder.extractor.IExtractorCreator;
import com.tencent.tav.decoder.logger.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AVExtractorFactory {
    private static final String TAG = "AVExtractorFactory";
    private Map<String, IExtractorCreator> mCreators;
    private String mCurCreatorType;
    private ReentrantReadWriteLock mLock;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static final class Inner {
        private static final AVExtractorFactory INSTANCE = new AVExtractorFactory();

        Inner() {
        }
    }

    public static AVExtractorFactory getInstance() {
        return Inner.INSTANCE;
    }

    private void registerDefaultCreator() {
        registerCreator(FfmpegExtractorCreator.TAG, new FfmpegExtractorCreator());
    }

    public IExtractor createExtractor() {
        return createExtractor(this.mCurCreatorType);
    }

    public Set<String> getCreators() {
        return this.mCreators.keySet();
    }

    public String getCurCreator() {
        return this.mCurCreatorType;
    }

    public boolean registerCreator(String str, @NonNull IExtractorCreator iExtractorCreator) {
        if (!TextUtils.isEmpty(str) && !this.mCreators.containsKey(str)) {
            this.mLock.writeLock().lock();
            this.mCreators.put(str, iExtractorCreator);
            this.mLock.writeLock().unlock();
            return true;
        }
        Logger.e(TAG, "register extractor error. type is null or the type has registered.");
        return false;
    }

    public boolean setCurCreator(@NonNull String str) {
        if (!this.mCreators.containsKey(str)) {
            Logger.e(TAG, "the creator type has not registered:" + str);
            return false;
        }
        this.mCurCreatorType = str;
        return true;
    }

    public void unRegisterCreator(String str) {
        if (!TextUtils.isEmpty(str) && this.mCreators.containsKey(str)) {
            this.mLock.writeLock().lock();
            this.mCreators.remove(str);
            this.mLock.writeLock().unlock();
            return;
        }
        Logger.e(TAG, "unRegister extractor error. type is null or the type has not registered.");
    }

    AVExtractorFactory() {
        this.mLock = new ReentrantReadWriteLock();
        this.mCreators = null;
        this.mCurCreatorType = FfmpegExtractorCreator.TAG;
        this.mCreators = new HashMap();
        registerDefaultCreator();
    }

    public IExtractor createExtractor(String str) {
        if (!TextUtils.isEmpty(str) && this.mCreators.containsKey(str)) {
            this.mLock.readLock().lock();
            IExtractorCreator iExtractorCreator = this.mCreators.get(str);
            this.mLock.readLock().unlock();
            if (iExtractorCreator == null) {
                Logger.e(TAG, "create extractor error. type is null or the type has not registered.");
                return null;
            }
            return iExtractorCreator.createExtractor();
        }
        Logger.e(TAG, "create extractor error. type is null or the type has not registered.");
        return null;
    }
}
